package com.yanglao.sys.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.common.vo.constant.SystemConstant;
import com.yanglao.config.JWTUtils;
import com.yanglao.sys.entity.HospitalAppointment;
import com.yanglao.sys.entity.MakeAppointment;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.HospitalAppointmentMapper;
import com.yanglao.sys.mapper.MakeAppointmentMapper;
import com.yanglao.sys.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张旭
 * @since 2023-04-04
 */
@RestController
@RequestMapping("/hospitalAppointment")
public class HospitalAppointmentController {

    //分页呈现
    @Autowired
    private HospitalAppointmentMapper hospitalAppointmentMapper;
    @Autowired
    private MakeAppointmentMapper makeAppointmentMapper;
    @GetMapping("/paging")

    public Result<List<HospitalAppointment>> getHospitalAppointmentMapper() {
        List<HospitalAppointment> list = hospitalAppointmentMapper.selectList(null);
        return Result.success(list, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<List<HospitalAppointment>> SearchUser1(String day) {

        List<HospitalAppointment> initialList = hospitalAppointmentMapper.selectList(null);


        QueryWrapper<MakeAppointment> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("appointment_time",day)
                .eq("processing_result","1");
        List<MakeAppointment> Appointment=makeAppointmentMapper.selectList(queryWrapper);

        for (HospitalAppointment i: initialList){
            for (MakeAppointment j:Appointment){
                String time = j.getAppointmentTime().split(",")[1];
                if(i.getHospitalAppointmentTime().equals(time)){
                    System.out.println("有重复的");
                    i.setHospitalAppointmentNumber(i.getHospitalAppointmentNumber()-1);
                }
            }
        }

        //System.out.println(page);
        return Result.success(initialList, "查询成功");
    }

    //更新
    @PostMapping("/update")
    public void UpdateHospitalAppointment(@RequestBody HospitalAppointment hospitalAppointment) {
        System.out.println(hospitalAppointment);
        //修改条件
        UpdateWrapper<HospitalAppointment> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("hospital_appointment_id", hospitalAppointment.getHospitalAppointmentId());

        int result = hospitalAppointmentMapper.update(hospitalAppointment, UpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertHospitalAppointment(@RequestBody HospitalAppointment hospitalAppointment) {
        System.out.println(hospitalAppointment);
        int result = hospitalAppointmentMapper.insert(hospitalAppointment);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateHospitalAppointment(Integer hospitalAppointmentId) {
        System.out.println(hospitalAppointmentId);
        //修改条件
        UpdateWrapper<HospitalAppointment> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("hospital_appointment_id", hospitalAppointmentId);

        int result = hospitalAppointmentMapper.delete(UpdateWrapper);
        System.out.println(result);
    }
}
