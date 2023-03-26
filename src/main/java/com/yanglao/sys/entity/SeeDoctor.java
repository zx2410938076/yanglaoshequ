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
    private LocalDateTime seeDoctorTime;

    public Integer getSeeDoctorId() {
        return seeDoctorId;
    }

    public void setSeeDoctorId(Integer seeDoctorId) {
        this.seeDoctorId = seeDoctorId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
    public String getDiagnosticResult() {
        return diagnosticResult;
    }

    public void setDiagnosticResult(String diagnosticResult) {
        this.diagnosticResult = diagnosticResult;
    }
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
    public LocalDateTime getSeeDoctorTime() {
        return seeDoctorTime;
    }

    public void setSeeDoctorTime(LocalDateTime seeDoctorTime) {
        this.seeDoctorTime = seeDoctorTime;
    }

    @Override
    public String toString() {
        return "SeeDoctor{" +
            "seeDoctorId=" + seeDoctorId +
            ", userId=" + userId +
            ", symptom=" + symptom +
            ", diagnosticResult=" + diagnosticResult +
            ", doctorId=" + doctorId +
            ", seeDoctorTime=" + seeDoctorTime +
        "}";
    }
}
