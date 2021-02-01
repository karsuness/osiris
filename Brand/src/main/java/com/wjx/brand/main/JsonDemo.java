package com.wjx.brand.main;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wjx.brand.domain.HujingResult;
import com.wjx.brand.domain.HujingResultDetail;
import com.wjx.brand.domain.HujingSalespersonFriendResponse;

import java.util.List;

/**
 * @author wangjinxin
 * @date 2021/2/1 23:32
 * @mail wjxScott@163.com
 * @description
 */
public class JsonDemo {
    public static void main(String[] args) {
        String json = "{\"code\":0,\"message\":null,\"data\":{\"totalCount\":5,\"totalPage\":1,\"currentPage\":1,\"result\":[{\"friendId\":111589300,\"user_wx_id\":null,\"nick\":\"【午间分享】0118期挖财理财小白53\",\"chat_title\":\"【午间分享】0118期挖财理财小白53\",\"type\":1,\"friend_wx_id\":\"24881969630@chatroom\",\"alias\":\"\",\"headimg\":\"\",\"is_deleted\":0,\"phone\":null,\"remark_phone\":null,\"contacts_phone\":null,\"createTime\":\"2021-01-2021:13:40\",\"friend_type\":0},{\"friendId\":111594396,\"user_wx_id\":null,\"nick\":\"【午间分享】0118期挖财理财小白52\",\"chat_title\":\"【午间分享】0118期挖财理财小白52\",\"type\":1,\"friend_wx_id\":\"23335308975@chatroom\",\"alias\":\"\",\"headimg\":\"\",\"is_deleted\":0,\"phone\":null,\"remark_phone\":null,\"contacts_phone\":null,\"createTime\":\"2021-01-2021:13:47\",\"friend_type\":0},{\"friendId\":111923607,\"user_wx_id\":null,\"nick\":\"周一\",\"chat_title\":\"周一\",\"type\":1,\"friend_wx_id\":\"21829399302@chatroom\",\"alias\":\"\",\"headimg\":\"\",\"is_deleted\":0,\"phone\":null,\"remark_phone\":null,\"contacts_phone\":null,\"createTime\":\"2021-01-2118:41:16\",\"friend_type\":0},{\"friendId\":112161279,\"user_wx_id\":null,\"nick\":\"【入群禁言中】0125期挖财理财小白99\",\"chat_title\":\"【入群禁言中】0125期挖财理财小白99\",\"type\":1,\"friend_wx_id\":\"24158899376@chatroom\",\"alias\":\"\",\"headimg\":\"\",\"is_deleted\":0,\"phone\":null,\"remark_phone\":null,\"contacts_phone\":null,\"createTime\":\"2021-01-2214:37:09\",\"friend_type\":0},{\"friendId\":112238533,\"user_wx_id\":null,\"nick\":\"【入群禁言】0125期挖财理财小白98\",\"chat_title\":\"【入群禁言】0125期挖财理财小白98\",\"type\":1,\"friend_wx_id\":\"23271399744@chatroom\",\"alias\":\"\",\"headimg\":\"\",\"is_deleted\":0,\"phone\":null,\"remark_phone\":null,\"contacts_phone\":null,\"createTime\":\"2021-01-2217:06:40\",\"friend_type\":0}]}}";

        HujingResult hujingResult = JSONObject.parseObject(json, HujingResult.class);

        JSONObject data = hujingResult.getData();

        HujingResultDetail<HujingSalespersonFriendResponse> hujing = data.toJavaObject(new TypeReference<HujingResultDetail<HujingSalespersonFriendResponse>>(){});

        List<HujingSalespersonFriendResponse> result = hujing.getResult();

        result.forEach(e->{
            System.out.println(e);
        });

//        System.out.println(result);

    }
}
