package com.flash.cards.core.base.service;

import com.flash.cards.core.base.dao.BaseDao;
import com.flash.cards.core.base.entity.BaseEntity;
import com.flash.cards.exception.PrimaryKeyException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author lizheng
 * @since 2018/8/14 16:45
 **/
public abstract class AbstractUpdateCommand <T extends BaseDao<E, ID>, E extends BaseEntity, ID extends Serializable> implements BaseUpdateCommand<T, E, ID>, BaseCommand<E>{
    @Autowired
    private T dao;
    protected E update(E e) {
        if (e.getId() == null) {
            throw new PrimaryKeyException();
        }
        e = dao.save(e);
        return e;
    }
}
