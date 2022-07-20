package com.my.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname ShiroController
 * @Description TODO
 * @Date 2022/4/12 20:37
 * @Created by GuoYuan
 */
@Configuration
public class ShiroController {
    //创建ShiroFilterFactoryBean关联DefaultWebSecurityManager
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("SecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
            anon:无需认证就可访问
            authc:必须认证了才能访问
            user:必须拥有 记住我 功能才可以访问
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        //filterMap.put("/toLook","perms[admin]");
        //filterMap.put("/user/*","perms[user]");
        filterMap.put("/admin/*","perms[admin]");
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/tonoauth");
        bean.setUnauthorizedUrl("/tonot");
        return bean;
    }
    //创建DefaultWebSecurityManager关联UserRealm
    @Bean(name = "SecurityManager")
    public DefaultWebSecurityManager dafaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合ShiroDialect；用来整合 shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
