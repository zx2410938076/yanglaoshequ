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
@TableName("physical_examination")
public class PhysicalExamination implements Serializable {

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
     * 体检项目
     */
    private String physicalExaminationItems;

    /**
     * 体检结果
     */
    private String physicalExaminationResult;

//    体检数值
    private String physicalExaminationValue;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 体检时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime physicalExaminationTime;

    /**
     * 体检id
     */
    private Integer physicalExaminationId;

    /**
     * 医生姓名
     */
    private String doctorName;


}
