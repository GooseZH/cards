package com.flash.cards.exception;

/**
 * 反射：无该域异常
 * @author lizheng
 * @since 2018/5/25 11:30
 **/
public class NoFieldException extends RuntimeException {
    public NoFieldException(String msg) {
        super(msg);
    }
}
