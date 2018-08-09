package com.flash.cards.core.paging;

import java.util.List;

/**
 * 分页参数
 *  @author lizheng
 * @since 2018/5/11 16:12
 **/
public class LocalPage<T> extends BasalPage {
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
