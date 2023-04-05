package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.MakeAppointment;
import com.yanglao.sys.entity.Request;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.MakeAppointmentMapper;
import com.yanglao.sys.mapper.RequestMapper;
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
 * @since 2023-03-18
 * 医生预约
 */
@RestController
@RequestMapping("/makeAppointment")
public class MakeAppointmentController {
    //分页呈现
    @Autowired
    private MakeAppointmentMapper makeAppointmentMapper;
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/paging")

    public Result<Page<MakeAppointment>> getAll(long current, long size) {
        Page<MakeAppointment> page = new Page<>(current, size);

        makeAppointmentMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<MakeAppointment>> Search(long current, long size, String target, String state) {

        Page<MakeAppointment> page = new Page<>(current, size);
        if(target.equals("")) {
            makeAppointmentMapper.selectPage(page, null);
            return Result.success(page, "查询成功");
        }
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        List<SysUser> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        String user = String.valueOf(users.get(0).getUserId());

        QueryWrapper<MakeAppointment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user);
        makeAppointmentMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void Update(@RequestBody MakeAppointment MakeAppointment) {
        System.out.println(MakeAppointment);
        //修改条件
        UpdateWrapper<MakeAppointment> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("appointment_id", MakeAppointment.getAppointmentId());

        int result = makeAppointmentMapper.update(MakeAppointment, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void Insert(@RequestBody MakeAppointment MakeAppointment) {
        System.out.println(MakeAppointment);
        int result = makeAppointmentMapper.insert(MakeAppointment);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void Update(Integer AppointmentId) {
        System.out.println(AppointmentId);
        //修改条件
        UpdateWrapper<MakeAppointment> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("appointment_id", AppointmentId);

        int result = makeAppointmentMapper.delete(UpdateWrapper);
        System.out.println(result);
    }
}
