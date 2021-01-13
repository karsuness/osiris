package com.wjx.teemo.domain.utils.sftp;

import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

/**
 * @author wangjinxin
 * @date 2019-06-04 17:50
 * @mail wjxScott@iCloud.com
 * @description sftp 工具类
 */
@Slf4j
public class SftpUtils {

    private static final String TYPE = "sftp";

    /**
     * channel
     */
    private static ChannelSftp channelSftp;

    /**
     * session
     */
    private static Session session;

    /**
     * sftp建立连接
     *
     * @param userName
     * @param host
     * @param port
     */
    private static void connect(String userName, String password, String host, Integer port) throws JSchException {
        JSch jsch = new JSch();
        session = jsch.getSession(userName, host, port);
        session.setPassword(password);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        log.info("sftp connect建立");

        Channel channel = session.openChannel(TYPE);
        channel.connect();

        log.info("channel is connected");

        channelSftp = (ChannelSftp) channel;
    }

    /**
     * sftp断开连接
     */
    private static void disConnect() {
        if (channelSftp != null) {
            if (channelSftp.isConnected()) {
                channelSftp.disconnect();
                if (log.isInfoEnabled()) {
                    log.info("sftp is closed already");
                }
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
                if (log.isInfoEnabled()) {
                    log.info("sshSession is closed already");
                }
            }
        }
    }

    /**
     * 单个文件上传
     *
     * @param sftpInfo
     * @return
     */
    public static Boolean uploadFile(SftpInfo sftpInfo) throws JSchException, IOException, SftpException {
        log.info("开始调用SftpUtils的uploadFile,参数是{}", sftpInfo);
        FileInputStream fileInputStream = null;
        try {
            connect(sftpInfo.getUsername(), sftpInfo.getPassword(), sftpInfo.getHost(), sftpInfo.getPort());

            String remotePath = sftpInfo.getRemotePath();
            String remoteFileName = sftpInfo.getRemoteFileName();
            String localPath = sftpInfo.getLocalPath();
            String localFileName = sftpInfo.getLocalFileName();

            createDir(remotePath);

            File file = new File(localPath, localFileName);

            fileInputStream = new FileInputStream(file);
            channelSftp.put(fileInputStream, remoteFileName);
            disConnect();
            return true;
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    /**
     * 下载文件
     *
     * @param sftpInfo
     * @return
     */
    public static Boolean downloadFile(SftpInfo sftpInfo) throws JSchException, IOException, SftpException {
        FileOutputStream fileOutputStream = null;
        try {
            connect(sftpInfo.getUsername(), sftpInfo.getPassword(), sftpInfo.getHost(), sftpInfo.getPort());
            String localPath = sftpInfo.getLocalPath();
            String localFileName = sftpInfo.getLocalFileName();
            String remotePath = sftpInfo.getRemotePath();
            String remoteFileName = sftpInfo.getRemoteFileName();
            String localFilePath = localPath + "/" + localFileName;
            String remoteFilePath = remotePath + "/" + remoteFileName;
            channelSftp.cd(remotePath);
            File file = new File(localFilePath);
            mkdirs(localFilePath);
            fileOutputStream = new FileOutputStream(file);
            channelSftp.get(remoteFilePath, fileOutputStream);
            disConnect();
            return true;
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();

            }
        }
    }


    /**
     * 删除stfp文件
     *
     * @param sftpInfo
     */
    public static Boolean deleteFile(SftpInfo sftpInfo) throws JSchException, SftpException {
        connect(sftpInfo.getUsername(), sftpInfo.getPassword(), sftpInfo.getHost(), sftpInfo.getPort());
        String deletePath = sftpInfo.getDeletePath();
        String deleteFileName = sftpInfo.getDeleteFileName();
        channelSftp.cd(deletePath);
        channelSftp.rm(deleteFileName);
        disConnect();
        return true;

    }


    /**
     * 创建目录
     *
     * @param createPath
     * @return
     */
    private static Boolean createDir(String createPath) throws SftpException {
        if (isDirExist(createPath)) {
            channelSftp.cd(createPath);
            return true;
        }
        String[] pathArray = createPath.split("/");
        StringBuffer filePath = new StringBuffer("/");
        for (String path : pathArray) {
            if (StringUtils.EMPTY.equals(path)) {
                continue;
            }
            filePath.append(path + "/");
            if (isDirExist(filePath.toString())) {
                channelSftp.cd(filePath.toString());
            } else {
                // 建立目录
                channelSftp.mkdir(filePath.toString());
                // 进入并设置为当前目录
                channelSftp.cd(filePath.toString());
            }
        }
        channelSftp.cd(createPath);
        return true;
    }

    /**
     * 判断目录是否存在
     *
     * @param directory
     * @return
     */
    private static Boolean isDirExist(String directory) {
        try {
            SftpATTRS sftpATTRS = channelSftp.lstat(directory);
            return sftpATTRS.isDir();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 如果目录不存在就创建目录
     *
     * @param path
     */
    private static void mkdirs(String path) {
        File f = new File(path);
        String fs = f.getParent();
        f = new File(fs);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    /**
     * 列出目录下的文件
     *
     * @param sftpInfo
     * @return
     * @throws SftpException
     */
    public static Vector listFiles(SftpInfo sftpInfo) throws JSchException, SftpException {
        connect(sftpInfo.getUsername(), sftpInfo.getPassword(), sftpInfo.getHost(), sftpInfo.getPort());
        Vector vector = channelSftp.ls(sftpInfo.getRemotePath());
        disConnect();
        return vector;
    }
}
