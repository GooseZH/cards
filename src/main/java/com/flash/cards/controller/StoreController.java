package com.flash.cards.controller;

import com.flash.cards.common.enums.ErrorCode;
import com.flash.cards.common.enums.StoreTypeEnum;
import com.flash.cards.controller.params.AddStoreParams;
import com.flash.cards.controller.params.DeleteStoreParams;
import com.flash.cards.controller.params.UpdateStoreParams;
import com.flash.cards.core.base.controller.BaseController;
import com.flash.cards.core.base.request.JsonRest;
import com.flash.cards.db.store.*;
import com.flash.cards.db.user.User;
import com.flash.cards.utils.BeanMergeTool;
import com.flash.cards.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 店铺
 * @author lizheng
 * @since 2018/8/13 17:42
 **/
@Controller
@RequestMapping("/store")
public class StoreController extends BaseController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private AddStoreCommand addStoreCommand;
    @Autowired
    private UpdateStoreCommand updateStoreCommand;
    @Autowired
    private DeleteStoreCommand deleteStoreCommand;

    /**
     * 获取店铺列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public JsonRest queryStore() {
        User user = getCurrentUser();
        List<Store> storeList = storeService.findStoreByUser(user);
        return new JsonRest(storeList);
    }

    /**
     * 添加店铺
     *
     * @param addStoreParams
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public JsonRest add(AddStoreParams addStoreParams) {
        Store store = BeanUtils.getBean(addStoreParams, Store.class, true);
        User user = this.getCurrentUser();
        // 1.参数再次处理(对于不匹配字段的处理)
        store.setType(StoreTypeEnum.getEnumByCode(addStoreParams.getStoreType()));
        store.setUser(user);
        store.setCreateBy(user.getUsername());
        store.setUpdateBy(user.getUsername());
        return addStoreCommand.excute(store);
    }

    /**
     * 修改店铺
     *
     * @param updateStoreParams
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonRest update(UpdateStoreParams updateStoreParams) {
        Store store = storeService.findOneById(updateStoreParams.getId());
        if (store == null) {
            return new JsonRest(ErrorCode.STORE_NOT_EXIST);
        }
        return updateStoreCommand.excute(BeanMergeTool.merge(store, updateStoreParams));
    }

    /**
     * 删除店铺
     *
     * @param deleteStoreParams
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonRest delete(DeleteStoreParams deleteStoreParams) {
        Store store = storeService.findOneById(deleteStoreParams.getId());
        if (store == null) {
            return new JsonRest(ErrorCode.STORE_NOT_EXIST);
        }
        return deleteStoreCommand.excute(store);
    }
}
