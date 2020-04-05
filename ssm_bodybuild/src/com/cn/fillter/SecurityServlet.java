// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.fillter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;

public class SecurityServlet extends HttpServlet implements Filter
{
    private static final long serialVersionUID = 1L;
    
    public void doFilter(final ServletRequest arg0, final ServletResponse arg1, final FilterChain arg2) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest)arg0;
        final HttpServletResponse response = (HttpServletResponse)arg1;
        final String count = (String)request.getSession().getAttribute("account");
        final String url = request.getRequestURI();
        if (url.indexOf("login") < 0) {
            if (count == null || "".equals(count)) {
                response.sendRedirect(String.valueOf(request.getContextPath()) + "/login.jsp");
            }
            else {
                arg2.doFilter(arg0, arg1);
            }
        }
        else {
            arg2.doFilter(arg0, arg1);
        }
        if (url.contains(".css") || url.contains(".js") || url.contains(".png")) {
            arg2.doFilter(arg0, arg1);
        }
    }
    
    public void init(final FilterConfig arg0) throws ServletException {
    }
}
