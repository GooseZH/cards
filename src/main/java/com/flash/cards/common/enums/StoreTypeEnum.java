package com.flash.cards.common.enums;

import com.flash.cards.core.lang.BaseBeanConverter;
import com.flash.cards.core.lang.BaseBeanEnum;
import com.flash.cards.exception.NotExistEnumException;

/**
 * 店铺类型
 * @author lizheng
 * @since 2018/8/13 17:30
 **/
public enum StoreTypeEnum implements BaseBeanEnum<Integer> {
    OTHER   (0, "其他");

    private Integer code;
    private String desc;

    private StoreTypeEnum(Integer code, String desc) {
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

    public static StoreTypeEnum getEnumByCode(Integer code) {
        for (StoreTypeEnum storeTypeEnum : StoreTypeEnum.values()) {
            if (storeTypeEnum.getCode() == code) {
                return storeTypeEnum;
            }
        }
        throw new NotExistEnumException();
    }

    public static class Convert extends BaseBeanConverter<StoreTypeEnum, Integer> {

    }
}
