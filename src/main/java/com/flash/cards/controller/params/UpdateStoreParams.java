package com.flash.cards.controller.params;

import javax.validation.constraints.NotNull;

/**
 * 修改店铺参数
 *
 * @author lizheng
 * @since 2018/8/14 16:43
 **/
public class UpdateStoreParams {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
