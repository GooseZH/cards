package com.flash.cards.controller.vo;

/**
 * @author lizheng
 * @since 2018/8/7 17:57
 **/
public class LoginVO {
    private String token;

    public LoginVO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
