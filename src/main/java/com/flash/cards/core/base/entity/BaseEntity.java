package com.flash.cards.core.base.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * entity基类
 * @author lizheng
 * @since 2018/8/3 11:30
 **/
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
