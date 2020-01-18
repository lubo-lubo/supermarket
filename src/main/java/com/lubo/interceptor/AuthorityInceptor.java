package com.lubo.interceptor;

import com.lubo.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityInceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user= (User) request.getSession().getAttribute("user");
        if(user.getUserRole()==1){
            return true;
        }else{
            return false;
        }
    }
}
