package com.flash.cards.controller.params;

import javax.validation.constraints.NotNull;

/**
 * 登录参数
 * @author lizheng
 * @since 2018/8/7 16:44
 **/
public class LoginParams {
    @NotNull(message = "用户名不能为空")
    private String username;    // 用户名
    @NotNull(message = "密码不能为空")
    private String password;    // 密码

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
