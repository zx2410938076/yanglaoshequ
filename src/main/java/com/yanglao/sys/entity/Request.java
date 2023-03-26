package com.yanglao.sys.entity;

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
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求id
     */
    private Integer requestId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 请求类型
     */
    private String requestType;

    /**
     * 处理人id
     */
    private Integer handlerId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 处理时间
     */
    private LocalDateTime processingTime;

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
    public Integer getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Integer handlerId) {
        this.handlerId = handlerId;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public LocalDateTime getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(LocalDateTime processingTime) {
        this.processingTime = processingTime;
    }

    @Override
    public String toString() {
        return "Request{" +
            "requestId=" + requestId +
            ", userId=" + userId +
            ", requestType=" + requestType +
            ", handlerId=" + handlerId +
            ", remarks=" + remarks +
            ", processingTime=" + processingTime +
        "}";
    }
}
