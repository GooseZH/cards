package com.flash.cards.controller;

import com.flash.cards.common.cons.Conf;
import com.flash.cards.common.enums.ErrorCode;
import com.flash.cards.common.enums.UserStatuEnum;
import com.flash.cards.controller.params.LoginParams;
import com.flash.cards.controller.vo.LoginVO;
import com.flash.cards.controller.vo.UserVO;
import com.flash.cards.core.base.controller.BaseController;
import com.flash.cards.core.base.request.JsonRest;
import com.flash.cards.core.redis.LoginStore;
import com.flash.cards.db.user.User;
import com.flash.cards.db.user.UserService;
import com.flash.cards.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * 登录/登出/用户信息等
 * @author lizheng
 * @since 2018/8/8 10:51
 **/
@Controller
public class IndexController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param loginParams
     * @return
     */
    @RequestMapping("/login/login")
    @ResponseBody
    public JsonRest login(@RequestBody @Valid LoginParams loginParams) {
        User user = userService.findByUsername(loginParams.getUsername());
        if (user == null) {
            return new JsonRest(ErrorCode.USER_USERNAME_NOT_FOUND);
        }
        if (!loginParams.getPassword().equals(user.getPassword())) {
            return new JsonRest(ErrorCode.USER_PASSWORD_ERROR);
        }
        // 判断用户状态
        // 判断用户身份：管理员、店铺、用户
        if (user.getStatus() != UserStatuEnum.OK) {
            return new JsonRest(ErrorCode.USER_STATUS_ERROR);
        }
        String sessionId = UUID.randomUUID().toString();
        LoginStore.put(sessionId, user);
        LoginVO loginVO = new LoginVO(sessionId);
        return new JsonRest(loginVO);
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @RequestMapping("/login/logout")
    @ResponseBody
    public JsonRest logout(HttpServletRequest request) {
        String token = request.getHeader(Conf.STR.TOKEN);
        if (StringUtil.isEmpty(token)) {
            return new JsonRest(ErrorCode.UN_LOGIN);
        }
        User user = LoginStore.get(token);
        if (user != null) {
            LoginStore.remove(token);
        }
        return JsonRest.OK;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping("/user/info")
    @ResponseBody
    public JsonRest getUserInfo(@NotNull(message = "Token不能为空") String token) {
        User user = LoginStore.get(token);
        if (user == null) {
            return new JsonRest(ErrorCode.UN_LOGIN);
        }
        user = userService.findByUsername(user.getUsername());
        if (user == null) {
            return new JsonRest(ErrorCode.USER_NOT_FOUND);
        }

        UserVO userVO = UserVO.Factory.getVO(user);
        return new JsonRest(userVO);
    }
}
