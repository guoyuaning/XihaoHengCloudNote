package com.my.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname LoginHandlerInterceptor
 * @Description TODO
 * @Date 2022/4/13 19:50
 * @Created by GuoYuan
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录之后，应该有用户的session
        Object loginUser = request.getSession().getAttribute("username");
        if(loginUser == null){
            request.setAttribute("msg","没有权限，请先登录");
            //下方错误待处理
            request.getRequestDispatcher("/toLogin").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
