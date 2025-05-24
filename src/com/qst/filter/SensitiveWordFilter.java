package com.qst.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
 * @author qst
 *
 * 敏感字滤器类
 *
 */
@WebFilter("/*")
public class SensitiveWordFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        MyRequest myRequest=new MyRequest((HttpServletRequest)request);
        chain.doFilter(myRequest, response);//用自定义的请求替换原始的请求

    }
}
