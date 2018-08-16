package com.flash.cards.db.store;

import com.flash.cards.core.base.request.JsonRest;
import com.flash.cards.core.base.service.AbstractUpdateCommand;
import org.springframework.stereotype.Service;

/**
 * 修改商铺
 * @author lizheng
 * @since 2018/8/14 16:50
 **/
@Service("updateStoreCommand")
public class UpdateStoreCommand extends AbstractUpdateCommand<StoreDao, Store, Integer> {
    @Override
    public JsonRest excute(Store store) {
        this.update(store);
        return JsonRest.OK;
    }
}
