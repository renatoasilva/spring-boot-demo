package com.example.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggerInterceptor implements HandlerInterceptor {

    Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Override
    public void afterCompletion(HttpServletRequest request,
        HttpServletResponse response, Object object, Exception arg3)
        throws Exception {
        log.info("Request is complete");
    }

    @Override
    public void postHandle(HttpServletRequest request,
        HttpServletResponse response, Object object, ModelAndView model)
        throws Exception {
        log.info("Handler execution is complete");
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object object) throws Exception {
        log.info("Before Handler execution");
        return true;
    }

}
