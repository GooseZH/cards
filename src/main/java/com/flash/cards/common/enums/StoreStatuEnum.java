package com.flash.cards.common.enums;

import com.flash.cards.core.lang.BaseBeanConverter;
import com.flash.cards.core.lang.BaseBeanEnum;

/**
 * 店铺状态
 * @author lizheng
 * @since 2018/8/13 17:33
 **/
public enum StoreStatuEnum implements BaseBeanEnum<Integer> {
    NORMAL   (0, "正常");

    private Integer code;
    private String desc;

    private StoreStatuEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static class Convert extends BaseBeanConverter<StoreStatuEnum, Integer> {

    }
}
