package com.wjx.osiris.hecarim.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjx.osiris.hecarim.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liusha
 * @date 2022/5/3 15:03
 * @mail liusha@wacai.com
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
