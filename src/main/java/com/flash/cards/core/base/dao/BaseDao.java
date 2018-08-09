package com.flash.cards.core.base.dao;

import com.flash.cards.core.base.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 底层DAO 基类
 * @author lizheng
 * @since 2018/5/10 21:30
 **/
@MappedSuperclass
public interface BaseDao<E extends BaseEntity,ID extends Serializable> extends JpaRepository<E, ID>, PagingAndSortingRepository<E, ID>,JpaSpecificationExecutor<E> {
}
