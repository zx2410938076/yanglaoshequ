package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2023-03-27
 */
@TableName("doctor_advice")
public class DoctorAdvice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 建议id
     */
    private Integer adviceId;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 活动建议
     */
    private String activitySuggestion;

    /**
     * 食材推荐
     */
    private String ingredientRecommendation;

    /**
     * 食材避免
     */
    private String foodAvoidance;

    /**
     * 建议时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime suggestedTime;
    /**
     * 状态
     */
    private String state;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
    public String getActivitySuggestion() {
        return activitySuggestion;
    }

    public void setActivitySuggestion(String activitySuggestion) {
        this.activitySuggestion = activitySuggestion;
    }
    public String getIngredientRecommendation() {
        return ingredientRecommendation;
    }

    public void setIngredientRecommendation(String ingredientRecommendation) {
        this.ingredientRecommendation = ingredientRecommendation;
    }
    public String getFoodAvoidance() {
        return foodAvoidance;
    }

    public void setFoodAvoidance(String foodAvoidance) {
        this.foodAvoidance = foodAvoidance;
    }
    public LocalDateTime getSuggestedTime() {
        return suggestedTime;
    }

    public void setSuggestedTime(LocalDateTime suggestedTime) {
        this.suggestedTime = suggestedTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DoctorAdvice{" +
                "userId=" + userId +
                ", adviceId=" + adviceId +
                ", doctorId=" + doctorId +
                ", activitySuggestion='" + activitySuggestion + '\'' +
                ", ingredientRecommendation='" + ingredientRecommendation + '\'' +
                ", foodAvoidance='" + foodAvoidance + '\'' +
                ", suggestedTime=" + suggestedTime +
                ", state='" + state + '\'' +
                '}';
    }
}
