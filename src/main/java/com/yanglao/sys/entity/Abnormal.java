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
public class Abnormal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 异常数据id
     */
    private Integer abnormalId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 异常项目
     */
    private String abnormalItem;

    /**
     * 异常数据
     */
    private String abnormalValue;

    /**
     * 异常登记时间
     */
    private LocalDateTime abnormalTime;

    /**
     * 处理状态
     */
    private String processingState;

    public Integer getAbnormalId() {
        return abnormalId;
    }

    public void setAbnormalId(Integer abnormalId) {
        this.abnormalId = abnormalId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getAbnormalItem() {
        return abnormalItem;
    }

    public void setAbnormalItem(String abnormalItem) {
        this.abnormalItem = abnormalItem;
    }
    public String getAbnormalValue() {
        return abnormalValue;
    }

    public void setAbnormalValue(String abnormalValue) {
        this.abnormalValue = abnormalValue;
    }
    public LocalDateTime getAbnormalTime() {
        return abnormalTime;
    }

    public void setAbnormalTime(LocalDateTime abnormalTime) {
        this.abnormalTime = abnormalTime;
    }
    public String getProcessingState() {
        return processingState;
    }

    public void setProcessingState(String processingState) {
        this.processingState = processingState;
    }

    @Override
    public String toString() {
        return "Abnormal{" +
            "abnormalId=" + abnormalId +
            ", userId=" + userId +
            ", abnormalItem=" + abnormalItem +
            ", abnormalValue=" + abnormalValue +
            ", abnormalTime=" + abnormalTime +
            ", processingState=" + processingState +
        "}";
    }
}
