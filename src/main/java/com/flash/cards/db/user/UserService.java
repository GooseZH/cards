package com.flash.cards.db.user;

import com.flash.cards.utils.StringUtil;
import com.flash.cards.core.base.service.AbstractQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lizheng
 * @since 2018/8/6 19:46
 **/
@Service("userService")
public class UserService extends AbstractQueryService<UserDao, User, Integer> {
    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        if (StringUtil.isEmpty(username)) {
            return null;
        }
        User user = userDao.findByUsername(username);
        return user;
    }

}
