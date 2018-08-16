package com.flash.cards.core.base.service;

import com.flash.cards.core.base.entity.BaseEntity;
import com.flash.cards.core.base.request.JsonRest;

/**
 * 命令基类
 * @author lizheng
 * @since 2018/8/14 16:03
 **/
public interface BaseCommand<E extends BaseEntity> {
    JsonRest excute(E object);
}
