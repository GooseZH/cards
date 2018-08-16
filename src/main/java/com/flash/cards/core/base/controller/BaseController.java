package com.flash.cards.core.base.controller;

import com.flash.cards.common.cons.Conf;
import com.flash.cards.core.redis.LoginStore;
import com.flash.cards.db.user.User;
import com.flash.cards.exception.UserNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lizheng
 * @since 2018/8/7 16:37
 **/
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected User getCurrentUser() {
        //获取到当前线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader(Conf.STR.TOKEN);
        User user = LoginStore.get(token);
        if (user == null) {
            throw new UserNotExistException();
        }
        return user;
    }
}
