package com.wjx.osiris.jhin.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjx.osiris.jhin.domain.entity.UserInfoDO;
import com.wjx.osiris.jhin.mapper.UserInfoMapper;
import com.wjx.qilin.annotation.LogAnnotation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangjinxin
 * @date 2021/3/21 21:11
 * @mail wjxScott@163.com
 * @description UserInfoService
 */
@Service
@LogAnnotation
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserInfoDO> {

    /**
     * 获取user
     *
     * @return
     */
    public List<UserInfoDO> listUserInfo() {
        return this.list();
    }
}
