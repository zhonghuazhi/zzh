package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by zhonghua on 16/3/1.
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void hasMatchCount() {
        boolean bool1 = userService.hasMatchUser("admin", "123456");
        boolean bool2 = userService.hasMatchUser("admin", "111111");

        Assert.assertTrue(bool1);
        Assert.assertTrue(!bool2);
    }

    @Test
    public void findUserByUserName() {

        User user = userService.findUserByUserName("admin");
        Assert.assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void loginSuccess(){

        User user = userService.findUserByUserName("admin");
        userService.loginSuccess(user);
    }

}