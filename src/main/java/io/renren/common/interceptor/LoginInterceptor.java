package io.renren.common.interceptor;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
     private Environment env;

    @Value("${test.name}")
     private String name;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String userNmae = (String) httpServletRequest.getSession().getAttribute("_userName");
        if(env.getProperty("test.enable-interceptor").equalsIgnoreCase("false")){
            System.out.println(name);
            return true;
        }
        if(StringUtils.isEmpty(userNmae)){//未登陆
            httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
            httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
            httpServletResponse.getWriter().write("尚未登陆请先登录");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
