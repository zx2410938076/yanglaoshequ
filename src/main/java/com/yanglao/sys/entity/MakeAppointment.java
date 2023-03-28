package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
     * 预约时间
     */
    private LocalDateTime appointmentTime;

    /**
     * 发起时间
     */
    private LocalDateTime initiationTime;

    /**
     * 医生id
     */
    private Integer doctorId;

    /**
     * 处理结果
     */
    private String processingResult;

    /**
     * 处理时间
     */
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

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public LocalDateTime getInitiationTime() {
        return initiationTime;
    }

    public void setInitiationTime(LocalDateTime initiationTime) {
        this.initiationTime = initiationTime;
    }
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
    public String getProcessingResult() {
        return processingResult;
    }

    public void setProcessingResult(String processingResult) {
        this.processingResult = processingResult;
    }
    public LocalDateTime getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(LocalDateTime processingTime) {
        this.processingTime = processingTime;
    }
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    public String getDoctorStatus() {
        return doctorStatus;
    }

    public void setDoctorStatus(String doctorStatus) {
        this.doctorStatus = doctorStatus;
    }
    public String getReservationRemarks() {
        return reservationRemarks;
    }

    public void setReservationRemarks(String reservationRemarks) {
        this.reservationRemarks = reservationRemarks;
    }
    public String getProcessingRemarks() {
        return processingRemarks;
    }

    public void setProcessingRemarks(String processingRemarks) {
        this.processingRemarks = processingRemarks;
    }


    @Override
    public String toString() {
        return "MakeAppointment{" +
            "appointmentId=" + appointmentId +
            ", userId=" + userId +
            ", appointmentTime=" + appointmentTime +
            ", initiationTime=" + initiationTime +
            ", doctorId=" + doctorId +
            ", processingResult=" + processingResult +
            ", processingTime=" + processingTime +
            ", userStatus=" + userStatus +
            ", doctorStatus=" + doctorStatus +
            ", reservationRemarks=" + reservationRemarks +
            ", processingRemarks=" + processingRemarks +
        "}";
    }
}
