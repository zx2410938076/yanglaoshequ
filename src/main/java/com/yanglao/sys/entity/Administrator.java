package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 张旭
 * @since 2023-04-21
 */
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员姓名
     */
    private String administratorName;

    /**
     * 管理员id
     */
    @TableId(value = "administrator_id", type = IdType.AUTO)
    private Integer administratorId;

    /**
     * 管理员账号
     */
    private Integer administratorNumber;

    /**
     * 管理员电话
     */
    private String administratorPhone;

    /**
     * 管理员角色
     */
    private String administratorAuthority;

    /**
     * 管理员密码
     */
    private String administratorPassword;

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }
    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }
    public Integer getAdministratorNumber() {
        return administratorNumber;
    }

    public void setAdministratorNumber(Integer administratorNumber) {
        this.administratorNumber = administratorNumber;
    }
    public String getAdministratorPhone() {
        return administratorPhone;
    }

    public void setAdministratorPhone(String administratorPhone) {
        this.administratorPhone = administratorPhone;
    }
    public String getAdministratorAuthority() {
        return administratorAuthority;
    }

    public void setAdministratorAuthority(String administratorAuthority) {
        this.administratorAuthority = administratorAuthority;
    }
    public String getAdministratorPassword() {
        return administratorPassword;
    }

    public void setAdministratorPassword(String administratorPassword) {
        this.administratorPassword = administratorPassword;
    }

    @Override
    public String toString() {
        return "Administrator{" +
            "administratorName=" + administratorName +
            ", administratorId=" + administratorId +
            ", administratorNumber=" + administratorNumber +
            ", administratorPhone=" + administratorPhone +
            ", administratorAuthority=" + administratorAuthority +
            ", administratorPassword=" + administratorPassword +
        "}";
    }
}
