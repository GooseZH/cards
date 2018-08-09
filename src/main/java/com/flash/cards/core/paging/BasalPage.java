package com.flash.cards.core.paging;

import com.flash.cards.common.cons.Conf;

/**
 * 分页最小参数
 * @author lizheng
 * @since 2018/8/3 16:52
 **/
public class BasalPage {
    private int pageNum = 1;
    private int pageSize = Conf.PAGE_SIZE.DEFAULT_SIZE;
    private int totalPageNum;
    private long totalNum;
    private String sortBy;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
