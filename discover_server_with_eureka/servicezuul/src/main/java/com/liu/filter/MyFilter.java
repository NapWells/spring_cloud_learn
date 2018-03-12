package com.liu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter{
    private static final Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {//过滤器类型：1、pre-路由之前 2、routing-路由之时 3、post-路由之后 4、error-发送错误调用
        return "pre";
    }

    @Override
    public int filterOrder() {//过滤的顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {//逻辑判断，是否要过滤，本文true,永远过滤
        return true;
    }

    @Override
    public Object run() {//过滤器的具体逻辑
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){

            }

            return null;
        }
        log.info("ok");
        return null;
    }
}
