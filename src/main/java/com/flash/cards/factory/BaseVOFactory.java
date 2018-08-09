package com.flash.cards.factory;

import com.flash.cards.utils.BeanUtils;

/**
 * @author lizheng
 * @since 2018/8/7 17:15
 **/
public abstract class BaseVOFactory<T, VO extends Object> {
    private static BaseVOFactory factory;

    public Object getVO(T t, Class<VO> clazz) {
        try {

            VO vo = BeanUtils.getBean(t, clazz);
            return vo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
