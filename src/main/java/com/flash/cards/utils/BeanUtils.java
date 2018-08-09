package com.flash.cards.utils;

import com.flash.cards.exception.IllegalAccessRuntimeException;
import com.flash.cards.exception.NoFieldException;
import com.flash.cards.exception.TransBeanException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象转换  orignal中所有字段会转换，无匹配的会抛出异常
 * @author lizheng
 * @since 2018/5/18 13:56
 **/
public class BeanUtils {
    private static final Logger log = LoggerFactory.getLogger(BeanUtils.class);

    /**
     * 返回List
     *
     * @param orignalList
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> List<T> getBeanBatch(List orignalList, Class<T> targetClass) {
        List<T> targetList = new ArrayList<>(orignalList.size());
        for (Object orignal : orignalList) {
            T t = getBean(orignal, targetClass, true);
            targetList.add(t);
        }
        return targetList;
    }

    /**
     * 对象转换  默认不匹配字段抛出异常
     * @param orignal
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Object orignal, Class<T> targetClass) {
        return getBean(orignal, targetClass, true);
    }

    /**
     *
     * @param orignal
     * @param targetClass
     * @param ignoreNoMatch  是否忽略不匹配字段
     * @param <T>
     * @return
     */
    public static <T> T getBean(Object orignal, Class<T> targetClass, boolean ignoreNoMatch) {
        T target = null;
        try {
            target = targetClass.newInstance();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new TransBeanException("无法实例化CLAZZ所对应的对象");
        }
        Field[] declaredFields = orignal.getClass().getDeclaredFields();
        Field[] fields = orignal.getClass().getFields();
        Field[] orignalFields = new Field[declaredFields.length + fields.length];
        System.arraycopy(declaredFields, 0, orignalFields, 0, declaredFields.length);
        System.arraycopy(fields, 0, orignalFields, declaredFields.length, fields.length);
        List<Field> commonFieldList = new ArrayList<>();
        for (int i = 0; i < orignalFields.length; i++) {
            Field orignalField = orignalFields[i];
            boolean orignalFlag = orignalField.isAccessible();
            Field targetField = null;
            try {
                targetField = targetClass.getDeclaredField(orignalField.getName());
            } catch (NoSuchFieldException e) {
                if (!ignoreNoMatch) {
                    throw new NoFieldException(orignalField.getName());
                } else {
                    continue;
                }
            }
            boolean targetFlag = targetField.isAccessible();
            try {
                orignalField.setAccessible(true);
                targetField.setAccessible(true);
                Object orignalValue = orignalField.get(orignal);
                targetField.set(target, orignalValue);
            } catch (IllegalAccessException illegal) {
                throw new IllegalAccessRuntimeException("获取属性值失败");
            } finally {
                orignalField.setAccessible(orignalFlag);
                targetField.setAccessible(targetFlag);
            }
        }
        return target;
    }
}
