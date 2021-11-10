package project7.security7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import project7.security7.util.ClientRequestInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Habib
 * @on 11/10/21 - 11:23 AM
 */
public class CustomerInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        clientRequestInfo.setClientIpAddress(request.getRemoteAddr());
        clientRequestInfo.setClientUrl(request.getRequestURI());
        clientRequestInfo.setSessionActivityId(request.getSession().getId());//request.getRequestedSessionId()
        return true;
    }
}
