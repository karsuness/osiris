package com.wjx.brand.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangjinxin
 * @date 2021/1/26 10:56
 * @mail wjxScott@icloud.com
 * @description 虎鲸系统销售获取好友请求Response
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HujingSalespersonFriendResponse {

    /**
     * 好友的id(chat_friend主键id)
     */
    private Integer friendId;

    /**
     * 添加好友时间（yyyy-MM-dd HH:mm:ss）
     */
    private String createTime;

    /**
     * 工作微信号
     */
    private String user_wx_id;

    /**
     * 好友昵称
     */
    private String nick;

    /**
     * 好友备注
     */
    private String chat_title;

    /**
     * 好友类型（0：单聊 1：群 2：群成员 ）
     * @see WXFriendTypeEnum
     */
    private Integer type;

    /**
     * 好友微信号
     */
    private String friend_wx_id;

    /**
     * 好友头像
     */
    private String headimg;

    /**
     * 删除状态（0：未删除 1：已删除 ）
     */
    private Integer is_deleted;

    /**
     * 好友别名（修改后的微信id）
     */
    private String alias;

    /**
     * 绑定手机号
     */
    private String phone;

    /**
     * 备注手机号
     */
    private String remark_phone;

    /**
     * 好友添加方式
     * @see FriendAddTypeEnum
     */
    private String friend_type;

    private String contacts_phone;
}
