package com.yanglao.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 张旭
 * @since 2023-04-04
 */
@TableName("hospital_appointment")
public class HospitalAppointment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医院预约id
     */
    private Integer hospitalAppointmentId;

    /**
     * 医院预约时间段
     */
    private String hospitalAppointmentTime;

    /**
     * 时间段内人数
     */
    private Integer hospitalAppointmentNumber;

    public Integer getHospitalAppointmentId() {
        return hospitalAppointmentId;
    }

    public void setHospitalAppointmentId(Integer hospitalAppointmentId) {
        this.hospitalAppointmentId = hospitalAppointmentId;
    }
    public String getHospitalAppointmentTime() {
        return hospitalAppointmentTime;
    }

    public void setHospitalAppointmentTime(String hospitalAppointmentTime) {
        this.hospitalAppointmentTime = hospitalAppointmentTime;
    }
    public Integer getHospitalAppointmentNumber() {
        return hospitalAppointmentNumber;
    }

    public void setHospitalAppointmentNumber(Integer hospitalAppointmentNumber) {
        this.hospitalAppointmentNumber = hospitalAppointmentNumber;
    }

    @Override
    public String toString() {
        return "HospitalAppointment{" +
            "hospitalAppointmentId=" + hospitalAppointmentId +
            ", hospitalAppointmentTime=" + hospitalAppointmentTime +
            ", hospitalAppointmentNumber=" + hospitalAppointmentNumber +
        "}";
    }
}
