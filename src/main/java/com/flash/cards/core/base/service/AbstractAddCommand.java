package com.flash.cards.core.base.service;

import com.flash.cards.core.base.dao.BaseDao;
import com.flash.cards.core.base.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * 抽象添加命令
 *
 * @author lizheng
 * @since 2018/8/14 15:57
 **/
public abstract class AbstractAddCommand<T extends BaseDao<E, ID>, E extends BaseEntity, ID extends Serializable> implements BaseAddCommand<T, E, ID>, BaseCommand<E>{
    @Autowired
    private T dao;
    protected E save(E e) {
        e = dao.save(e);
        return e;
    }
}
