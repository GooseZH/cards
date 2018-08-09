package com.flash.cards.core.base.entity;

import com.flash.cards.common.cons.Conf;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 删除字段
 * @author lizheng
 * @since 2018/8/3 11:35
 **/
@MappedSuperclass
public class BaseEntity4IsDelete extends BaseEntity {
    @Column(name = "is_delete")
    public Integer isDelete = Conf.IS_DELETE.OK;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
