package com.sayiamfun.springboot2mybatisdemo.config.authInterceptor;

import com.sayiamfun.springboot2mybatisdemo.common.WebConst;
import com.sayiamfun.springboot2mybatisdemo.entity.User;
import com.sayiamfun.springboot2mybatisdemo.utils.CookieUtil;
import com.sayiamfun.springboot2mybatisdemo.utils.JsonObjectUtils;
import com.sayiamfun.springboot2mybatisdemo.utils.SessionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static Log log = LogFactory.getLog(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            log.info("*********************************************");
            StringBuffer requestURL = request.getRequestURL();
            String ip = request.getRemoteHost();
            log.info(requestURL);
            String cookieValue = CookieUtil.getCookieValue(request, WebConst.COOKIEUSERKEY, true);
            System.out.println("cookie:  "+cookieValue);
            if(null != cookieValue){
                Object userObject = SessionUtil.getSession(request, WebConst.SESSIONUSERKEYPRE+cookieValue+WebConst.SESSIONUSERKEYSUFF);
                if(null != userObject){
                    //添加日志
                    User user = JsonObjectUtils.jsonToPojo(userObject.toString(), User.class);
                    request.setAttribute(WebConst.SESSIONUSERKEY,user);
                    System.out.println("Session:  "+user);
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("拦截器出错");
        }
        response.sendRedirect(WebConst.LOGINADDRESS);
        return false;
    }



}

