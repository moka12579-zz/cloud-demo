package com.baizhi;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luxiaoyang
 * @create 2020-03-20-10:08
 *
 * 定义了一个Zuul过滤器，实现了在请求被路由之前检查请求中是否有`accessToken`参数
 * 若有就进行路由，若没有就拒绝访问，返回`401 Unauthorized`错误。
 *
 * 在网关中不做页面跳转
 */
public class AccessFilter extends ZuulFilter {
//    日志
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * `filterType`：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *
     * - `pre`：可以在请求被路由之前调用  类似于前置增强
     * - `routing`：在路由请求时候被调用  类似于环绕
     * - `post`：在routing和error过滤器之后被调用  类似后置
     * - `error`：处理请求时发生错误时被调用  类似异常增强
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 如果有多个过滤器的时候 定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 定义过滤器能不能生效
     *
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * 定义过滤器要执行的内容
     *
     * @return
     */
    @Override
    public Object run() {
//        1.获取到Request对象
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
//        从Request中拿到token
        Object accessToken = request.getParameter("accessToken");
//        验证有没有token
        if(accessToken == null) {
//            没有响应一个401
            log.warn("access token is empty");
//            通过`ctx.setSendZuulResponse(false)`令zuul过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
//            然后通过`ctx.setResponseStatusCode(401)`设置了其返回的错误码
            ctx.setResponseStatusCode(401);
//            通过`ctx.setResponseBody(body)`对返回body内容进行编辑等
            ctx.setResponseBody("no token");
            return null;
        }
        log.info("access token ok");
//        return null代表放行
        return null;
    }
}
