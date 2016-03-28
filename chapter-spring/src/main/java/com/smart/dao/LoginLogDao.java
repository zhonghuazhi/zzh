package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by zhonghua on 16/2/22.
 */
@Repository
public class LoginLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 记录用户登陆日志
     *
     * @param loginLog
     */
    public void insertLoginLog(LoginLog loginLog) {

        String sql = "INSERT INTO t_login_log (user_id ,ip ,login_datetime) VALUES (?,?,?)";
        Object[] objs = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(sql, objs);
    }
}