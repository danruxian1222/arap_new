package com.cmb.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义登录验证过滤器
 */
public class LoginCheckPermissionFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object arg2) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURI();
        try {
            Subject subject = SecurityUtils.getSubject();

            return subject.isPermitted(url);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            saveRequestAndRedirectToLogin(request, response);
        } else {
            return true;
        }
        return false;
    }
}
