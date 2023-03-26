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
public class Disease implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 疾病
     */
    private String disease;

    /**
     * 登记时间
     */
    private LocalDateTime diseaseTime;

    /**
     * 疾病id
     */
    private Integer diseaseId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
    public LocalDateTime getDiseaseTime() {
        return diseaseTime;
    }

    public void setDiseaseTime(LocalDateTime diseaseTime) {
        this.diseaseTime = diseaseTime;
    }
    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    @Override
    public String toString() {
        return "Disease{" +
            "userId=" + userId +
            ", disease=" + disease +
            ", diseaseTime=" + diseaseTime +
            ", diseaseId=" + diseaseId +
        "}";
    }
}
