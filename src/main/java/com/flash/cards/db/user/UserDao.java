package com.flash.cards.db.user;

import com.flash.cards.core.base.dao.BaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author lizheng
 * @since 2018/8/6 10:54
 **/
public interface UserDao extends BaseDao<User, Integer> {
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Query("from User as u where u.username = :username")
    User findByUsername(@Param("username") String username);
}
