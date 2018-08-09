package com.flash.cards.core.base;


import com.flash.cards.core.paging.PageParams;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author lizheng
 * @since 2018/5/11 16:32
 **/
public class BuildPageRequest {
    public static PageRequest buildPageRequst(PageParams pageParams) {
        PageRequest pageRequest = null;
        if (pageParams.getSortBy() != null) {
            Sort sort = new Sort(pageParams.getSortBy());
            pageRequest = new PageRequest(pageParams.getPageNum() - 1, pageParams.getPageSize(), sort);
        } else pageRequest = new PageRequest(pageParams.getPageNum() - 1, pageParams.getPageSize());

        return pageRequest;
    }
}
