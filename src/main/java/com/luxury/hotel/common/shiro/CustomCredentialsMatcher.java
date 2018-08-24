package com.luxury.hotel.common.shiro;

import com.luxury.hotel.common.utils.MD5Util;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo){
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String password = String.valueOf(usernamePasswordToken.getPassword());
        Object tokenCredentials = MD5Util.encode(password);
        Object accountCredentials = authenticationInfo.getCredentials();
        return equals(tokenCredentials,accountCredentials);
    }
}
