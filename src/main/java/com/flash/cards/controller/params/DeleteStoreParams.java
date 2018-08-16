package com.flash.cards.controller.params;

import javax.validation.constraints.NotNull;

/**
 * 删除店铺
 * @author lizheng
 * @since 2018/8/14 17:13
 **/
public class DeleteStoreParams {
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
