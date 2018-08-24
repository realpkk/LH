package com.luxury.hotel.common.shiro;

import com.luxury.hotel.entity.user.Menu;
import com.luxury.hotel.entity.user.User;
import com.luxury.hotel.service.security.MenuService;
import com.luxury.hotel.service.security.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public class CustomAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @PostConstruct
    public void initCredentialsMatcher(){
        setCredentialsMatcher(new CustomCredentialsMatcher());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String phoneNumber = (String) principalCollection.getPrimaryPrincipal();
        User currentUser = userService.getCurrentUser(phoneNumber);
        List<Menu> menuList = menuService.findMenuTreeFromUser(currentUser);
        for (Menu menu:menuList){
            if (StringUtils.isNotEmpty(menu.getPermission())){
                authorizationInfo.addStringPermission(menu.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String phoneNumber = usernamePasswordToken.getUsername();
        User currentUser = userService.getCurrentUser(phoneNumber);
        if (currentUser != null) {
            return new SimpleAuthenticationInfo(currentUser.getPhoneNumber(),currentUser.getPassword(),getName());
        }else {
            return null;
        }
    }
}
