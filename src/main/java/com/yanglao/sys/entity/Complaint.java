package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户姓名
     */
    @TableField(exist = false)
    private String userName;

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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime processingTime;

    /**
     * 处理人姓名
     */
    private String handlerName;

}
