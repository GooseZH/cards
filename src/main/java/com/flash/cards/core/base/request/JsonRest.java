package com.flash.cards.core.base.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flash.cards.common.enums.ErrorCode;

/**
 * JSON返回数据  数据格式
 * @author lizheng
 * @since 2018/8/3 17:14
 **/
public class JsonRest<T> {
    public static final JsonRest OK = new JsonRest(ErrorCode.OK);
    public static final JsonRest ERROR = new JsonRest(ErrorCode.ERROR);
    private Integer code;
    private String msg;
    private T data;

    public JsonRest(T t) {
        this(ErrorCode.OK, t);
    }

    public JsonRest(ErrorCode errorCode) {
        this(errorCode, null);
    }

    public JsonRest(ErrorCode errorCode, T t) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.data = t;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @JsonIgnore
    public boolean isOK() {
        return code != null && code == 200;
    }
}
