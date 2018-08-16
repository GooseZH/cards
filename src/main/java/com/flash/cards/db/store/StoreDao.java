package com.flash.cards.db.store;

import com.flash.cards.core.base.dao.BaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author lizheng
 * @since 2018/8/13 17:40
 **/
public interface StoreDao extends BaseDao<Store, Integer> {
    @Query("from Store s where s.user.username = :username and s.isDelete = 0")
    List<Store> findByUser(@Param("username") String username);
}
