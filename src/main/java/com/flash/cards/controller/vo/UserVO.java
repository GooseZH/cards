package com.flash.cards.controller.vo;

import com.flash.cards.common.enums.UserRoleEnum;
import com.flash.cards.common.enums.UserStatuEnum;
import com.flash.cards.db.user.User;
import com.flash.cards.utils.BeanUtils;

import javax.persistence.Convert;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户返回对象
 * @author lizheng
 * @since 2018/8/7 17:01
 **/
public class UserVO {
    private String username; // 用户名
    private String password; // 密码
    private String phone; // 电话
    private String turename; // 真实姓名
    private String nickname; // 昵称
    private String email; // 邮箱
    @Convert(converter = UserRoleEnum.Convert.class)
    private UserRoleEnum role; //角色
    private UserStatuEnum status;
    // 为配合VUE-ADMIN，提供临时解决方案，后期优化时需要修改
    private List<String> roles;

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public static class Factory {
        public static UserVO getVO(User user) {
            try {
                UserVO userVO = BeanUtils.getBean(user, UserVO.class);
                afresh(userVO);
                return userVO;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        private static void afresh(UserVO userVO) {
            List<String> roles = new ArrayList<>();
            roles.add(userVO.getRole().getMsg());
            userVO.setRoles(roles);
        }
    }
}
