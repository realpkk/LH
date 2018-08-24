package com.luxury.hotel.controller.server.controller;

import com.luxury.hotel.entity.user.User;
import com.luxury.hotel.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/roleEdit")
    public void roleEdit(@RequestParam String phoneNumber,@RequestParam Long roleId){
        User user = userService.getCurrentUser(phoneNumber);
        userService.roleEdit(user,roleId);
    }
}
