package com.flash.cards.core.base.entity;

import javax.persistence.Column;

/**
 * 唯一识别字段
 * @author lizheng
 * @since 2018/8/3 11:46
 **/
public class BaseEntity4UniqueKey extends BaseEntity4Date {
    @Column(name = "unique_key")
    public String uniqueKey;

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}
