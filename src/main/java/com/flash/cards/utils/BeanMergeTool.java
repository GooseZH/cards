package com.flash.cards.utils;

import com.flash.cards.exception.IllegalAccessRuntimeException;
import com.flash.cards.exception.NoFieldException;

import java.lang.reflect.Field;

/**
 * 对象合并工具
 *
 * @author lizheng
 * @since 2018/8/14 16:55
 **/
public class BeanMergeTool {

    /**
     * 对象merge
     *
     * @param original
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Object> E merge(E original, Object target) {
        return merge(original, target, true);
    }
    /**
     * 会将target中的字段值 赋值到 original中
     *
     * @param original
     * @param target
     * @param <E>
     * @param ignore   忽略未匹配字段
     * @return
     */
    public static <E extends Object> E merge(E original, Object target, boolean ignore) {
        Class clazz4Original = original.getClass();
        Class clazz4Traget = target.getClass();
        Field[] fields4Target = clazz4Traget.getDeclaredFields();
        for (Field targetField : fields4Target) {
            String fieldName = targetField.getName();
            try {
                Field originalField = clazz4Original.getDeclaredField(fieldName);
                boolean bar = originalField.isAccessible();
                boolean bar2Target = targetField.isAccessible();
                originalField.setAccessible(true);
                targetField.setAccessible(true);
                originalField.set(original, targetField.get(target));
                originalField.setAccessible(bar);
                targetField.setAccessible(bar2Target);
            } catch (NoSuchFieldException e) {
                if (!ignore) {
                    throw new NoFieldException("ERROR:" + fieldName + "不存在");
                }
            } catch (IllegalAccessException e) {
                throw new IllegalAccessRuntimeException("ERROR:" + fieldName);
            }
        }
        return original;
    }
}
