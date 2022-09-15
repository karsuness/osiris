package com.wjx.osiris.fizz.config;

import cn.hutool.core.bean.BeanUtil;
import feign.FeignException;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.ContentType;
import feign.form.MultipartFormContentProcessor;
import feign.form.multipart.AbstractWriter;
import feign.form.multipart.Output;
import feign.form.spring.SpringFormEncoder;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.fileupload.util.mime.MimeUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignLoggerFactory;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/**
 * @author wangjinxin
 * @date 2022/8/5 18:40
 * @mail wangjinxin03@corp.netease.com
 * @description
 */
public class FeignExtension {

    public static class FeignExtensionConfiguration {

        private static int connectTimeOutMillis = 10000;
        private static int readTimeOutMillis = 0;

        @Autowired
        protected ObjectFactory<HttpMessageConverters> messageConverters;

        @Bean
        @Primary
        @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        @ConditionalOnMissingBean(Encoder.class)
        public Encoder urlEncoder() {
            return new UrlEncoder(new SpringEncoder(messageConverters));
        }

        @Bean
        @Primary
        @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        @ConditionalOnMissingBean(Decoder.class)
        public Decoder fileDecoder() {
            return new ResponseEntityDecoder(new FileDecoder(messageConverters));
        }

    }

    /**
     * 文件解析器，用于下载文件 {@link InMemoryMultipartFile}
     */
    public static class FileDecoder extends SpringDecoder {

        public FileDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
            super(messageConverters);
        }

        @Override
        public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
            if (type instanceof Class && MultipartFile.class.isAssignableFrom((Class) type)) {
                Collection<String> contentTypes = response.headers().get("content-type");
                String contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
                if (contentTypes.size() > 0) {
                    for (String ct : contentTypes) {
                        if (ct.contains(MediaType.APPLICATION_JSON_VALUE)) {
                            contentType = MediaType.APPLICATION_JSON_UTF8_VALUE;
                        }
                    }
                }

                byte[] bytes = StreamUtils.copyToByteArray(response.body().asInputStream());
                return new InMemoryMultipartFile("file", parseOriginFileName(response), contentType, bytes);
            } else {
                return super.decode(response, type);
            }
        }

        @SneakyThrows
        private String parseOriginFileName(Response response) {
            Collection<String> headerValues = response.headers().get(HttpHeaders.CONTENT_DISPOSITION);
            if (CollectionUtils.isEmpty(headerValues)) {
                return "";
            }

            String headerValue = headerValues.stream().findFirst().orElse("");
            ContentDisposition disposition = ContentDisposition.parse(headerValue);
            String filename = disposition.getFilename();
            if (filename != null) {
                if (filename.startsWith("=?") && filename.endsWith("?=")) {
                    filename = MimeUtility.decodeText(filename);
                }
                return filename;
            } else {
                return "";
            }
        }
    }

    public static class UrlEncoder extends MySpringFormEncoder {
        public UrlEncoder(Encoder delegate) {
            super(delegate);
        }

        @Override
        public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
            if (!HttpMethod.GET.matches(template.method()) && !HttpMethod.DELETE.matches(template.method())) {
                super.encode(object, bodyType, template);
                return;
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> data = Map.class.isAssignableFrom(object.getClass()) ? (Map<String, Object>) object : BeanUtil.beanToMap(object);
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                template.query(entry.getKey(), entry.getValue().toString());
            }
        }
    }


    /**
     * 用于Feign multipart/form-data 请求，处理本地没有File的情况
     */
    public static class MySpringFormEncoder extends SpringFormEncoder {
        public MySpringFormEncoder(Encoder delegate) {
            super(delegate);
            MultipartFormContentProcessor processor = (MultipartFormContentProcessor) getContentProcessor(ContentType.MULTIPART);
            processor.addFirstWriter(new SingleInputStreamWriter());
        }
    }

    /**
     * 用于Feign multipart/form-data 请求
     */
    public static class SingleInputStreamWriter extends AbstractWriter {

        @Override
        public boolean isApplicable(Object value) {
            return value instanceof InputStreamFile;
        }

        @SneakyThrows
        @Override
        protected void write(Output output, String key, Object value) throws EncodeException {
            val file = (InputStreamFile) value;
            writeFileMetadata(output, key, file.getFileName(), null);

            val input = file.getInputStream();
            val buf = new byte[1024];
            int length = input.read(buf);
            while (length > 0) {
                output.write(buf, 0, length);
                length = input.read(buf);
            }
        }
    }

    /**
     * 用于Feign multipart/form-data 请求
     */
    @Data
    public static class InputStreamFile {
        private String fileName;
        private InputStream inputStream;
    }

    /**
     * feign info 日志工厂
     */
    static class InfoFeignLoggerFactory implements FeignLoggerFactory {

        @Override
        public feign.Logger create(Class<?> type) {
            return new InfoFeignLogger(LoggerFactory.getLogger(type));
        }
    }

    /**
     * Info级别的Feign日志
     */
    private static class InfoFeignLogger extends feign.Logger {
        private final Logger logger;

        private InfoFeignLogger(Logger logger) {
            this.logger = logger;
        }

        @Override
        protected void log(String configKey, String format, Object... args) {
            if (logger.isInfoEnabled()) {
                logger.info(String.format(methodTag(configKey) + format, args));
            }
        }
    }
}
