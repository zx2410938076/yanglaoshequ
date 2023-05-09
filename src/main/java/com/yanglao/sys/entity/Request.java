package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
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
     * 用户姓名
     */
    @TableField(exist = false)
    private String userName;

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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime processingTime;

    /**
     * 处理人姓名
     */
    private String handlerName;

}
