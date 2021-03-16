package com.wjx.osiris.zed.domain.util.sftp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangjinxin
 * @date 2019-06-04 17:58
 * @mail wjxScott@iCloud.com
 * @description sftp实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SftpInfo {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 主机ip
     */
    private String host;

    /**
     * 端口号
     */
    private Integer port;

    /**
     * sftp上文件地址
     */
    private String remotePath;

    /**
     * sftp上文件名
     */
    private String remoteFileName;

    /**
     * 本地文件路径
     */
    private String localPath;

    /**
     * 本地文件名
     */
    private String localFileName;

    /**
     * 要删除文件的sftp路径
     */
    private String deletePath;

    /**
     * 要删除文件的sftp文件名
     */
    private String deleteFileName;
}
