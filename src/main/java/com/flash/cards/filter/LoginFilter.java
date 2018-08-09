package com.flash.cards.filter;

import com.flash.cards.common.cons.Conf;
import com.flash.cards.common.enums.ErrorCode;
import com.flash.cards.core.base.request.JsonRest;
import com.flash.cards.core.redis.LoginStore;
import com.flash.cards.db.user.User;
import com.flash.cards.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录过滤器
 *
 * @author lizheng
 * @since 2018/8/9 14:49
 **/
public class LoginFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("LoginFilter init.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.过滤URL
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String requestMethod = req.getMethod();
        if (!"OPTIONS".equals(requestMethod)) {
            String cookieSessionId = req.getHeader(Conf.STR.TOKEN);
            User xxlUser = LoginStore.get(cookieSessionId);
            if (xxlUser == null) {
                res.setHeader("Access-Control-Allow-Origin", "*");
                res.setCharacterEncoding("UTF-8");
                res.setContentType("application/json; charset=utf-8");
                PrintWriter out = res.getWriter();

                out.append(JacksonUtil.writeValueAsString(new JsonRest<>(ErrorCode.UN_LOGIN)));
                out.flush();
                out.close();
                return;
            }
        }
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        logger.info("SSOServerFilter destroy.");
    }

}
