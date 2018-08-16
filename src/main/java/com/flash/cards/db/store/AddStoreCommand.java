package com.flash.cards.db.store;

import com.flash.cards.common.enums.ErrorCode;
import com.flash.cards.core.base.request.JsonRest;
import com.flash.cards.core.base.service.AbstractAddCommand;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 添加店铺
 * @author lizheng
 * @since 2018/8/14 16:06
 **/
@Service("addStoreCommand")
public class AddStoreCommand extends AbstractAddCommand<StoreDao, Store, Integer> {
    @Override
    public JsonRest excute(Store store) {
        // 2.默认参数构造
        store.setCreateTime(new Date());
        store.setUpdateTime(new Date());
        // 3.参数校验
        store = this.save(store);
        if (store.getId() == null) {
            return new JsonRest(ErrorCode.BEAN_SAVE_ERROR);
        }
        return new JsonRest(store);
    }
}
