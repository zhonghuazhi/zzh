package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhonghua on 16/2/22.
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据用户名和密码获取匹配的用户数
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public int getMatchCount(String userName, String password) {

        String sqlStr = "SELECT count(*) FROM t_user WHERE " +
                "user_name = ? AND password = ?";
        return jdbcTemplate.queryForInt(sqlStr, new Object[]{userName, password});
    }

    /**
     * 根据用户名获取用户对象
     *
     * @param userName 用户名
     * @return
     */
    public User findlUserByUsername(String userName) {

        String sqlStr = "SELECT user_id ,user_name FROM t_user WHERE user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
            }
        });
        return user;
    }

    /**
     * 更新用户积分、最后登陆IP、最后登陆时间
     *
     * @param user 用户
     */
    public void updateLoginInfo(User user) {

        String sqlStr = "UPDATE t_user SET last_visit = ? ," +
                "last_ip = ? WHERE user_id = ?";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(),
                user.getLastIp(), user.getUserId()});
    }
}