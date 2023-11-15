package com.yanglao.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    /**
     * 活动推荐
     */
    private boolean recommend;
}
