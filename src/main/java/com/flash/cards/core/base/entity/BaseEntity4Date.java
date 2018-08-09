package com.flash.cards.core.base.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 时间基类
 * @author lizheng
 * @since 2018/8/3 11:43
 **/
@MappedSuperclass
public class BaseEntity4Date extends BaseEntity4IsDelete {
    @Column(name = "create_time")
    public Date createTime;
    @Column(name = "create_by")
    public String createBy;
    @Column(name = "update_time")
    public Date updateTime;
    @Column(name = "update_by")
    public String updateBy;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
