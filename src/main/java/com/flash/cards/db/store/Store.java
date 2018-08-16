package com.flash.cards.db.store;

import com.flash.cards.common.enums.StoreStatuEnum;
import com.flash.cards.common.enums.StoreTypeEnum;
import com.flash.cards.core.base.entity.BaseEntity4Date;
import com.flash.cards.db.user.User;

import javax.persistence.*;

/**
 * 店铺
 * @author lizheng
 * @since 2018/8/13 17:27
 **/
@Entity
@Table(name = "tbl_store")
public class Store extends BaseEntity4Date {
    private String name; // 店铺名
    private String address; // 店铺地址
    private String phone; // 联系电话
    @Convert(converter = StoreTypeEnum.Convert.class)
    private StoreTypeEnum type; // 店铺类型
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "username", referencedColumnName = "username", updatable = false)
    @Basic(fetch = FetchType.LAZY)
    private User user; // 拥有者
    @Convert(converter = StoreStatuEnum.Convert.class)
    private StoreStatuEnum status = StoreStatuEnum.NORMAL; // 状态
    private String homePage; // 店铺首页

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StoreTypeEnum getType() {
        return type;
    }

    public void setType(StoreTypeEnum type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StoreStatuEnum getStatus() {
        return status;
    }

    public void setStatus(StoreStatuEnum status) {
        this.status = status;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }
}
