package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhonghua on 16/2/23.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    /**
     * @param userName
     * @param password
     * @return
     */
    public boolean hasMatchUser(String userName, String password) {

        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    /**
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName) {
        return userDao.findlUserByUsername(userName);
    }

    /**
     * @param user
     */
    public void loginSuccess(User user) {

        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());

        loginLogDao.insertLoginLog(loginLog);
    }
}