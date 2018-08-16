package com.flash.cards.db.store;

import com.flash.cards.core.base.request.JsonRest;
import com.flash.cards.core.base.service.AbstractDeleteCommand;
import org.springframework.stereotype.Service;

/**
 * 店铺删除命令
 *
 * @author lizheng
 * @since 2018/8/14 17:18
 **/
@Service("deleteStoreCommand")
public class DeleteStoreCommand extends AbstractDeleteCommand<StoreDao, Store, Integer> {
    @Override
    public JsonRest excute(Store store) {
        delete(store);
        return JsonRest.OK;
    }
}
