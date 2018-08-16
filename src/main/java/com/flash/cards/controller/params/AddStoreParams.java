package com.flash.cards.controller.params;

/**
 * 添加店铺
 *
 * @author lizheng
 * @since 2018/8/14 15:48
 **/
public class AddStoreParams {
    private String name; // 店铺名称
    private String address; // 地址
    private String phone; // 联系电话
    private Integer storeType; // 店铺类型
    private String homePage;

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

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }
}
