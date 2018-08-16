package com.flash.cards.db.store;

import com.flash.cards.core.base.service.AbstractQueryService;
import com.flash.cards.db.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 店铺
 * @author lizheng
 * @since 2018/8/13 17:41
 **/
@Service("storeService")
public class StoreService extends AbstractQueryService<StoreDao, Store, Integer> {
    public List<Store> findStoreByUser(User user) {
        if (user == null) {
            return new ArrayList<>();
        }
        List<Store> storeList = dao.findByUser(user.getUsername());
        return storeList;
    }
}
