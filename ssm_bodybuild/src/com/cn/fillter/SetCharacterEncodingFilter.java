// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.fillter;

import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.FilterConfig;
import javax.servlet.Filter;

public class SetCharacterEncodingFilter implements Filter
{
    protected String encoding;
    protected FilterConfig filterConfig;
    
    public SetCharacterEncodingFilter() {
        this.encoding = null;
        this.filterConfig = null;
    }
    
    public void destroy() {
    }
    
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);
        chain.doFilter(request, response);
    }
    
    public void init(final FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");
    }
}
