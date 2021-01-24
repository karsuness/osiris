package com.wjx.teemo.domain.util.file;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

/**
 * @author wangjinxin
 * @date 2019-08-08 18:31
 * @mail wjxScott@iCloud.com
 * @description 文件操作工具类
 */
public class FileUtil {
    public static String fileDownload(String remoteFileUrl, String fileName, String fileDir) {
        HttpURLConnection connection = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;

        String filePath = fileDir + "/" + fileName;
        try {
            Throwable t = null;
            try {
                // 创建保存文件的目录
                File saveFile = new File(fileDir);
                if (!saveFile.exists()) {
                    saveFile.mkdir();
                }

                // 创建保存的文件
                File file = new File(filePath);
                if (!file.exists()) {
                    file.createNewFile();
                }

                URL url = new URL(remoteFileUrl);
                // 将url以open方法返回的urlConnection连接强转为HttpURLConnection连接(标识一个url所引用的远程对象连接)
                // 此时connection只是为一个连接对象,待连接中
                connection = (HttpURLConnection) url.openConnection();
                // 设置是否要从 URL连接读取数据,默认为true
                connection.setDoInput(true);
                // 建立连接
                // (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)
                connection.connect();
                // 连接发起请求,处理服务器响应 (从连接获取到输入流)
                inputStream = connection.getInputStream();
                // 创建文件输出流，用于保存下载的远程文件
                outputStream = new FileOutputStream(file);
                //  用来存储响应数据
                byte[] buffer = new byte[4 * 1024];
                int byteRead = -1;
                //  循环读取流
                while ((byteRead = (inputStream.read(buffer))) != -1) {
                    outputStream.write(buffer, 0, byteRead);
                }
                //  输出完成后刷新并关闭流
                outputStream.flush();
            } catch (Exception e1) {
                t = e1;
                e1.printStackTrace();
            } finally {
                try {
                    //  重要且易忽略步骤 (关闭流,切记!)
                    if (Objects.nonNull(inputStream)) {
                        if (Objects.nonNull(t)) {
                            //代码有异常
                            try {
                                inputStream.close();
                            } catch (Throwable e2) {
                                //如果close出现异常，作为被压制异常添加
                                t.addSuppressed(e2);
                            }
                        } else {
                            //代码中没有异常，close出现的异常就是最后catch块中的e
                            inputStream.close();
                        }
                    }
                    if (Objects.nonNull(outputStream)) {
                        //代码有异常
                        try {
                            outputStream.close();
                        } catch (Throwable e2) {
                            //如果close出现异常，作为被压制异常添加
                            t.addSuppressed(e2);
                        }
                    } else {
                        //代码中没有异常，close出现的异常就是最后catch块中的e
                        outputStream.close();
                    }
                    // 销毁连接
                    if (Objects.nonNull(connection)) {
                        //代码有异常
                        try {
                            connection.disconnect();
                        } catch (Throwable e2) {
                            //如果close出现异常，作为被压制异常添加
                            t.addSuppressed(e2);
                        }
                    } else {
                        //代码中没有异常，close出现的异常就是最后catch块中的e
                        connection.disconnect();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 返回保存后的文件路径
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
