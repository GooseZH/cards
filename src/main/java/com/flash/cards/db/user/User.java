package com.flash.cards.db.user;

import com.flash.cards.common.enums.UserRoleEnum;
import com.flash.cards.common.enums.UserStatuEnum;
import com.flash.cards.core.base.entity.BaseEntity4Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lizheng
 * @since 2018/8/6 10:06
 **/
@Entity
@Table(name = "tbl_user")
public class User extends BaseEntity4Date {
    private String username; // 用户名
    private String password; // 密码
    private String phone; // 电话
    private String turename; // 真实姓名
    private String nickname; // 昵称
    private String email; // 邮箱
    @Convert(converter = UserRoleEnum.Convert.class)
    private UserRoleEnum role; //角色
    @Convert(converter = UserStatuEnum.Convert.class)
    private UserStatuEnum status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTurename() {
        return turename;
    }

    public void setTurename(String turename) {
        this.turename = turename;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public UserStatuEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatuEnum status) {
        this.status = status;
    }
}
