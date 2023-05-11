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
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("see_doctor")
public class SeeDoctor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 就诊id
     */
    private Integer seeDoctorId;

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
     * 症状
     */
    private String symptom;

    /**
     * 诊断结果
     */
    private String diagnosticResult;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 就诊时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime seeDoctorTime;

    /**
     * 医生姓名
     */
    private String doctorName;

}
