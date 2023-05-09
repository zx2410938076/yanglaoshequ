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
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动时间
     */
    private LocalDateTime activityTime;

    /**
     * 活动地点
     */
    private String activityLocation;

    /**
     * 负责人名称
     */
    private String responsiblePerson;

    /**
     * 活动简介
     */
    private String activityProfile;

    /**
     * 活动图片
     */
    private String activityPic;

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", activityTime=" + activityTime +
                ", activityLocation='" + activityLocation + '\'' +
                ", responsiblePerson='" + responsiblePerson + '\'' +
                ", activityProfile='" + activityProfile + '\'' +
                ", activityPic='" + activityPic + '\'' +
                '}';
    }

    public String getActivityPic() {
        return activityPic;
    }

    public void setActivityPic(String activityPic) {
        this.activityPic = activityPic;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    public LocalDateTime getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(LocalDateTime activityTime) {
        this.activityTime = activityTime;
    }
    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }
    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }
    public String getActivityProfile() {
        return activityProfile;
    }

    public void setActivityProfile(String activityProfile) {
        this.activityProfile = activityProfile;
    }

}
