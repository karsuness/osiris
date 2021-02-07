package com.wjx.aphelios.spring.dao.impl;


import com.wjx.aphelios.spring.dao.UserDao;
import com.wjx.aphelios.spring.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author WJX
 * @since 2018/4/22 21:01
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer add(User user) {
        String sql = "insert into user(name,age) values(?,?)";
        int updateNum = jdbcTemplate.update(sql, user.getName(), user.getAge());
        return updateNum;
    }

    @Override
    public Integer update(User user, Integer id) {
        String sql = "update user set name = ?,age = ? where id = ?";
        int updateNum = jdbcTemplate.update(sql, user.getName(), user.getAge(), id);
        return updateNum;
    }

    @Override
    public Integer deleteById(Integer id) {
        String sql = "delete from user where id = ?";
        int updateNum = jdbcTemplate.update(sql, id);
        return updateNum;
    }

    @Override
    public Integer deleteAll() {
        String sql = "delete from user";
        int updateNum = jdbcTemplate.update(sql);
        return updateNum;
    }

    @Override
    public User getUserById(Integer id) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        }, id);
        return user;
    }

    @Override
    public List<User> getUserList() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        return list;
    }

    @Override
    public Integer getUserCount() {
        String sql = "select count(*) from user";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class);
        return num;
    }
}
