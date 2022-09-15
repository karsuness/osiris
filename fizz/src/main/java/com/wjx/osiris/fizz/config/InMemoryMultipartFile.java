package com.wjx.osiris.fizz.config;

import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author wangjinxin
 * @date 2022/8/5 18:40
 * @mail wangjinxin03@corp.netease.com
 * @description 来自 https://github.com/spring-cloud/spring-cloud-netflix/issues/2246
 */
public class InMemoryMultipartFile implements MultipartFile {

    private final String name;
    private final String originalFileName;
    private final String contentType;
    private final byte[] payload;

    public InMemoryMultipartFile(File file) throws IOException {
        this.originalFileName = file.getName();
        this.payload = FileCopyUtils.copyToByteArray(file);
        this.name = "file";
        this.contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
    }

    public InMemoryMultipartFile(String name, InputStream inputStream) {
        this(name, name, inputStream);
    }

    @SneakyThrows
    public InMemoryMultipartFile(String name, String originalFileName, InputStream inputStream) {
        this.name = name;
        this.originalFileName = originalFileName;
        this.payload = FileCopyUtils.copyToByteArray(inputStream);
        this.contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
    }

    public InMemoryMultipartFile(String originalFileName, byte[] payload) {
        this.originalFileName = originalFileName;
        this.payload = payload;
        this.name = "file";
        this.contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
    }

    public InMemoryMultipartFile(String name, String originalFileName, String contentType, byte[] payload) {
        if (payload == null) {
            throw new IllegalArgumentException("Payload cannot be null.");
        }
        this.name = name;
        this.originalFileName = originalFileName;
        this.contentType = contentType;
        this.payload = payload;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOriginalFilename() {
        return originalFileName;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    public boolean isFileContent() {
        return contentType != null && contentType.contains(MediaType.APPLICATION_OCTET_STREAM_VALUE);
    }

    public String getBodyAsString() {
        return new String(payload, StandardCharsets.UTF_8);
    }

    @Override
    public boolean isEmpty() {
        return payload.length == 0;
    }

    @Override
    public long getSize() {
        return payload.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return payload;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(payload);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        try {
            fileOutputStream.write(payload);
        } finally {
            fileOutputStream.close();
        }
    }
}