package com.luxury.hotel.controller.login.controller;

import com.luxury.hotel.common.enums.PromptMessageEnum;
import com.luxury.hotel.common.enums.UserTypeEnum;
import com.luxury.hotel.common.utils.MD5Util;
import com.luxury.hotel.entity.user.User;
import com.luxury.hotel.service.security.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model, @RequestParam String phoneNumber,
                        @RequestParam String password){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(phoneNumber,password);
        try {
            currentUser.login(usernamePasswordToken);
        }catch (AuthenticationException e){
            model.addAttribute("message", PromptMessageEnum.PHONE_PASSWORD_ERROR.getValue());
            model.addAttribute("phoneNumberSession",phoneNumber);
            return "login";
        }
        model.addAttribute("user",userService.getCurrentUser(phoneNumber));
        model.addAttribute("userTypeEnum", UserTypeEnum.values());
        return "homepage";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(Model model,@RequestParam String phoneNumber,
                           @RequestParam String password,
                           @RequestParam String name,
                           @RequestParam String identityCode){
        String dateBasePassword = MD5Util.encode(password);
        User user = new User(phoneNumber,name,identityCode,dateBasePassword);
        if (userService.duplicateCheck(phoneNumber)) {
            model.addAttribute("message", PromptMessageEnum.PHONE_NUMBER_REGISTERED.getValue());
            model.addAttribute("nameSession",name);
            model.addAttribute("identityCodeSession",identityCode);
            return "register";
        }else {
            userService.createNewUser(user);
            return "login";
        }
    }

    @RequestMapping("/homepage")
    public String toHomepage(){
        return "homepage";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();

        return "login";
    }
}
