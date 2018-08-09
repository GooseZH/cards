package com.flash.cards.core.redis;

import com.flash.cards.common.cons.Conf;
import com.flash.cards.db.user.User;

/**
 * local login store
 *
 * @author lizheng 20:03:11
 */
public class LoginStore {

    /**
     * get
     *
     * @param sessionId
     * @return
     */
    public static User get(String sessionId) {

        String redisKey = redisKey(sessionId);
        Object objectValue = JedisFactory.getObjectValue(redisKey);
        if (objectValue != null) {
            User xxlUser = (User) objectValue;
            return xxlUser;
        }
        return null;
    }

    /**
     * remove
     *
     * @param sessionId
     */
    public static void remove(String sessionId) {
        String redisKey = redisKey(sessionId);
        JedisFactory.del(redisKey);
    }

    /**
     * put
     *
     * @param sessionId
     * @param xxlUser
     */
    public static void put(String sessionId, User xxlUser) {
        String redisKey = redisKey(sessionId);
        JedisFactory.setObjectValue(redisKey, xxlUser);
    }

    private static String redisKey(String sessionId){
        return Conf.STR.SESSIONID.concat("#").concat(sessionId);
    }

}
