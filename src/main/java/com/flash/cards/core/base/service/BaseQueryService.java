package com.flash.cards.core.base.service;

import com.flash.cards.core.base.dao.BaseDao;
import com.flash.cards.core.base.entity.BaseEntity;

import java.io.Serializable;

/**
 * 查找基类
 * @author lizheng
 * @since 2018/8/3 15:42
 **/
public interface BaseQueryService <DAO extends BaseDao<E, ID>, E extends BaseEntity, ID extends Serializable>{
}
