package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
@TableName("physical_examination")
public class PhysicalExamination implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 体检项目
     */
    private String physicalExaminationItems;

    /**
     * 体检结果
     */
    private String physicalExaminationResult;

//    体检数值
    private String physicalExaminationValue;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 体检时间
     */
    private LocalDateTime physicalExaminationTime;

    /**
     * 体检id
     */
    private Integer physicalExaminationId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getPhysicalExaminationItems() {
        return physicalExaminationItems;
    }

    public void setPhysicalExaminationItems(String physicalExaminationItems) {
        this.physicalExaminationItems = physicalExaminationItems;
    }
    public String getPhysicalExaminationResult() {
        return physicalExaminationResult;
    }

    public void setPhysicalExaminationResult(String physicalExaminationResult) {
        this.physicalExaminationResult = physicalExaminationResult;
    }
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
    public LocalDateTime getPhysicalExaminationTime() {
        return physicalExaminationTime;
    }

    public void setPhysicalExaminationTime(LocalDateTime physicalExaminationTime) {
        this.physicalExaminationTime = physicalExaminationTime;
    }
    public Integer getPhysicalExaminationId() {
        return physicalExaminationId;
    }

    public void setPhysicalExaminationId(Integer physicalExaminationId) {
        this.physicalExaminationId = physicalExaminationId;
    }
    public String getPhysicalExaminationValue() {
        return physicalExaminationValue;
    }

    public void setPhysicalExaminationValue(String physicalExaminationValue) {
        this.physicalExaminationValue = physicalExaminationValue;
    }

    @Override
    public String toString() {
        return "PhysicalExamination{" +
            "userId=" + userId +
            ", physicalExaminationItems=" + physicalExaminationItems +
            ", physicalExaminationResult=" + physicalExaminationResult +
            ", doctorId=" + doctorId +
            ", physicalExaminationTime=" + physicalExaminationTime +
            ", physicalExaminationId=" + physicalExaminationId +
            ", physicalExaminationValue=" + physicalExaminationValue +
        "}";
    }
}
