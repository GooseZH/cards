package com.flash.cards.core.base.dao;

/**
 * @author lizheng
 * @since 2018/5/18 13:28
 **/
public interface UniqueKeyDao<E> {
    E findByUniqueKey(String UUID);
}