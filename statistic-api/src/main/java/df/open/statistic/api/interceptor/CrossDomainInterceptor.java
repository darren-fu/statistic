package df.open.statistic.api.interceptor;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 说明:
 * <p/>
 * Copyright: Copyright (c)
 * <p/>
 * Company: 江苏千米网络科技有限公司
 * <p/>
 *
 * @author 付亮(OF2101)
 * @version 1.0.0
 * @date 2016/8/30
 */

@Component
public class CrossDomainInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(CrossDomainInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (StringUtils.equals("OPTIONS", request.getMethod())) {
            log.warn("Get an OPTIONS request");
            response.setStatus(204);
            return false;
        }

        response.setHeader("Access-Control-Allow-Headers", "Platform,Origin,Content-Type");
        response.setHeader("Access-Control-Allow-Origin", ObjectUtils.defaultIfNull(request.getHeader("Origin"), " *"));
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Connection", "keep-alive");
        response.setHeader("Keep-Alive", "timeout=2, max=100");


        // 解决ie跨域不能使用cookie
        response.setHeader("P3P", "CP=CAO PSA OUR");

        return true;
    }
}
