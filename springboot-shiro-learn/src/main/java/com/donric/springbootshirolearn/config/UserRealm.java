package com.donric.springbootshirolearn.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

//    @Autowired
//    UserService userService;
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //加了下面的字段就可以授权了
        info.addStringPermission("user:add");
        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");

//        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
//        //连接真实数据库
//        User user = userService.queryUserByName(userToken.getUsername());
//        if (user==null){  // 没有这个人
//            return null  // UnknowAccountException
//        }

        // 用户名 ，密码  数据中取
        String name = "root";
        String password = "123456";

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        if (!userToken.getUsername().equals(name)){
            return null;  // 抛出异常 UnknownAccountException
        }

        // 密码认证，shiro做
        return new SimpleAuthenticationInfo("",password,"");
    }
}
