package com.wsk.inteceptor;


import com.wsk.pojo.UserInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("开启登录拦截器！");
        UserInformation userInformation = (UserInformation) request.getSession().getAttribute("userInformation");
        if(userInformation == null){
            response.sendRedirect("/login.do");
            return false;
        }else {
            return true;
        }
    }


}
