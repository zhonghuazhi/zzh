package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by zhonghua on 16/3/1.
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.html")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest httpServletRequest, LoginCommand loginCommand) {

        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());

        if (!isValidUser) {
            return new ModelAndView("login", "error", "用户密码不正确.");
        } else {

            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(httpServletRequest.getRemoteAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);

            httpServletRequest.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }
}
