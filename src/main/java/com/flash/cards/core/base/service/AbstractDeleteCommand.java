package com.flash.cards.core.base.service;

import com.flash.cards.common.cons.Conf;
import com.flash.cards.core.base.dao.BaseDao;
import com.flash.cards.core.base.entity.BaseEntity4IsDelete;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author lizheng
 * @since 2018/8/14 17:18
 **/
public abstract class AbstractDeleteCommand <T extends BaseDao<E, ID>, E extends BaseEntity4IsDelete, ID extends Serializable> implements BaseDeleteCommand<T, E, ID>, BaseCommand<E>{
    @Autowired
    private T dao;
    protected void delete(E e) {
        e.setIsDelete(Conf.IS_DELETE.DEL);
        dao.save(e);
    }
}
