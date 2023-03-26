package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 张旭
 * @since 2023-03-21
 */
@TableName("sys_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户账号
     */
    private Integer userNumber;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 住址
     */
    private String userAddress;

    /**
     * 爱好
     */
    private String userHobby;

    /**
     * 爱吃
     */
    private String userFood;

    /**
     * 忌口
     */
    private String userForbiddenFood;

    /**
     * 紧急联系人姓名
     */
    private String userRelativesName;

    /**
     * 紧急联系人电话
     */
    private String userRelativesPhone;

    /**
     * 权限
     */
    private String authority;

    /**
     * 头像
     */
    private String picture;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public String getUserHobby() {
        return userHobby;
    }

    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby;
    }
    public String getUserFood() {
        return userFood;
    }

    public void setUserFood(String userFood) {
        this.userFood = userFood;
    }
    public String getUserForbiddenFood() {
        return userForbiddenFood;
    }

    public void setUserForbiddenFood(String userForbiddenFood) {
        this.userForbiddenFood = userForbiddenFood;
    }
    public String getUserRelativesName() {
        return userRelativesName;
    }

    public void setUserRelativesName(String userRelativesName) {
        this.userRelativesName = userRelativesName;
    }
    public String getUserRelativesPhone() {
        return userRelativesPhone;
    }

    public void setUserRelativesPhone(String userRelativesPhone) {
        this.userRelativesPhone = userRelativesPhone;
    }
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "SysUser{" +
            "userId=" + userId +
            ", userNumber=" + userNumber +
            ", userPassword=" + userPassword +
            ", userName=" + userName +
            ", userPhone=" + userPhone +
            ", userAddress=" + userAddress +
            ", userHobby=" + userHobby +
            ", userFood=" + userFood +
            ", userForbiddenFood=" + userForbiddenFood +
            ", userRelativesName=" + userRelativesName +
            ", userRelativesPhone=" + userRelativesPhone +
            ", authority=" + authority +
            ", picture=" + picture +
        "}";
    }
}
