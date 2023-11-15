package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("make_appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeAppointment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预约id
     */
    private Integer appointmentId;

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
     * 预约时间
     */
    private String appointmentTime;

    /**
     * 发起时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime initiationTime;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 医生id
     */
    private String doctorName;

    /**
     * 处理结果
     */
    private String processingResult;

    /**
     * 处理时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime processingTime;

    /**
     * 用户阅读状态
     */
    private String userStatus;

    /**
     * 医生阅读状态
     */
    private String doctorStatus;

    //预约备注
    private String reservationRemarks;
    //处理备注
    private String processingRemarks;
}
