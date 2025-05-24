package com.qst.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
 * @author qst
 *
 * 字符过滤器类，设置支持中文的编码、解码字符集
 *
 */
@WebFilter(
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name="encode",value="utf-8")
        }
)
public class EncodeFilter implements Filter {
    private String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        if (uri.indexOf(".css") > 0 || uri.indexOf(".js") > 0 || uri.indexOf(".png") > 0) {//对css,js,图片等放行
            chain.doFilter(request, response);//将请求和响应向后传递
        } else {
            request.setCharacterEncoding(encode);//设置解码字符集
            response.setCharacterEncoding(encode);//设置响应时对响应内容进行编码采用字符集,默认ISO-8859-1
            response.setContentType("text/html;charset=" + encode);//添加响应头,告诉浏览器用utf-8解码响应内容
            chain.doFilter(request, response);//将请求和响应向后传递
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}