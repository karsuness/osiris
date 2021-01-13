package com.wjx.aphelios.oauth2.domain;

/**
 * @author WJX
 * @since 2018/5/23 16:39
 */

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable {
    /**
     * 用户唯一id
     */
    private Long id;
    /**
     * 本站登陆账号
     */
    private String account;
    /**
     * 登陆密码
     */
    private String passwd;
    /**
     * 第三方平台账号（openid）
     */
    private String thirdId;
    /**
     * 用户名
     */
    private String name;
    /**
     * 头像图片的二进制数据
     */
    private byte[] portraitData;

    /**
     * 用户头像名与用户id保持一致，所以只需要返回用户的id就行
     *
     * @return
     */
    public String getPortrait() {
        return id == null ? "default" : String.valueOf(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPortraitData() {
        return portraitData;
    }

    public void setPortraitData(byte[] portraitData) {
        this.portraitData = portraitData;
    }
}
