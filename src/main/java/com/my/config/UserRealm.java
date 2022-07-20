package com.my.config;

import com.my.pojo.Userinfo;
import com.my.service.UserinfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Classname UserRealm
 * @Description TODO
 * @Date 2022/4/12 20:41
 * @Created by GuoYuan
 */
//自定义的UserRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserinfoService userinfoService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        //SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        Userinfo currentUser = (Userinfo) subject.getPrincipal();
        info.addStringPermission(currentUser.getPerms());
        System.out.println("身份是" + currentUser.getPerms() + "登录成功！");
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("进入认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        List<Userinfo> userinfos = userinfoService.selectByUsername(userToken.getUsername());

        if(userinfos.isEmpty()){
            return null;
        }
        Userinfo userinfo = userinfos.get(0);
        //密码认证
        return new SimpleAuthenticationInfo(userinfo,userinfo.getPassword(),"");
    }
}