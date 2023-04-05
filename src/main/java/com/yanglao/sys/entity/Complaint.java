package com.yanglao.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

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
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 投诉部门
     */
    private String complaintDepartment;

    /**
     * 投诉id
     */
    private Integer complaintId;

    /**
     * 投诉对象
     */
    private String complaintObject;

    /**
     * 投诉描述
     */
    private String complaintDescription;

    /**
     * 处理人id
     */
    private String handlerId;

    /**
     * 投诉反馈
     */
    private String complaintFeedback;

    /**
     * 发起时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime initiationTime;

    /**
     * 处理时间
     */
    private LocalDateTime processingTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getComplaintDepartment() {
        return complaintDepartment;
    }

    public void setComplaintDepartment(String complaintDepartment) {
        this.complaintDepartment = complaintDepartment;
    }
    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }
    public String getComplaintObject() {
        return complaintObject;
    }

    public void setComplaintObject(String complaintObject) {
        this.complaintObject = complaintObject;
    }
    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }
    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }
    public String getComplaintFeedback() {
        return complaintFeedback;
    }

    public void setComplaintFeedback(String complaintFeedback) {
        this.complaintFeedback = complaintFeedback;
    }
    public LocalDateTime getInitiationTime() {
        return initiationTime;
    }

    public void setInitiationTime(LocalDateTime initiationTime) {
        this.initiationTime = initiationTime;
    }
    public LocalDateTime getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(LocalDateTime processingTime) {
        this.processingTime = processingTime;
    }

    @Override
    public String toString() {
        return "Complaint{" +
            "userId=" + userId +
            ", complaintDepartment=" + complaintDepartment +
            ", complaintId=" + complaintId +
            ", complaintObject=" + complaintObject +
            ", complaintDescription=" + complaintDescription +
            ", handlerId=" + handlerId +
            ", complaintFeedback=" + complaintFeedback +
            ", initiationTime=" + initiationTime +
            ", processingTime=" + processingTime +
        "}";
    }
}
