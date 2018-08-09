package com.flash.cards.core.lang;

import javax.persistence.AttributeConverter;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * 数据库 字段到枚举的映射
 * @author lizheng
 * @since 2018/5/9 12:59
 **/
public class BaseBeanConverter<X extends BaseBeanEnum<Y>, Y> implements AttributeConverter<BaseBeanEnum<Y>, Y> {
    private Class<X> xClass;
    private Method valuesMethod;

//    @SuppressWarnings("unchecked")
    {
        this.xClass = (Class<X>) (((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments())[0];
        try {
            valuesMethod = xClass.getMethod("values");
        } catch (Exception e) {
            throw new RuntimeException("EnumConvert : con`t get method from " + xClass);
        }
    }

    @Override
    public Y convertToDatabaseColumn(BaseBeanEnum<Y> attribute) {
        if (attribute == null)
            throw new RuntimeException("BaseBeanConverter : convert fail, because " + attribute + " is null");
        return attribute.getCode();
    }

    @Override
    public BaseBeanEnum<Y> convertToEntityAttribute(Y dbData) {
        try {
            X[] xes = (X[]) valuesMethod.invoke(null);
            for (X x : xes) if (x.getCode().equals(dbData)) return x;
        } catch (Exception e) {
            throw new RuntimeException("BaseBeanConverter : " + e.getMessage());
        }
        throw new RuntimeException("BaseBeanConverter : con`t find " + xClass + " by " + dbData);
    }
}
