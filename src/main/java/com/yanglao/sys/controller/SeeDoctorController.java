package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.PhysicalExamination;
import com.yanglao.sys.entity.SeeDoctor;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.PhysicalExaminationMapper;
import com.yanglao.sys.mapper.SeeDoctorMapper;
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
 */
@RestController
@RequestMapping("/seeDoctor")
public class SeeDoctorController {

    @Autowired
    private SeeDoctorMapper seeDoctorMapper;
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/paging")

    public Result<Page<SeeDoctor>> getAllRequest(long current, long size) {
        Page<SeeDoctor> page = new Page<>(current, size);

        seeDoctorMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<SeeDoctor>> SerchRequest(long current, long size, String target, String state) {

        Page<SeeDoctor> page = new Page<>(current, size);
        if(target.equals("")) {
            seeDoctorMapper.selectPage(page, null);
            return Result.success(page, "查询成功");
        }

        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        List<SysUser> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        String user = String.valueOf(users.get(0).getUserId());

        QueryWrapper<SeeDoctor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user);
        seeDoctorMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateUser(@RequestBody SeeDoctor SeeDoctor) {
        System.out.println(SeeDoctor);
        //修改条件
        UpdateWrapper<SeeDoctor> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("see_doctor_id", SeeDoctor.getSeeDoctorId());

        int result = seeDoctorMapper.update(SeeDoctor, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertUser(@RequestBody SeeDoctor SeeDoctor) {
        System.out.println(SeeDoctor);
        int result = seeDoctorMapper.insert(SeeDoctor);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateUser(Integer SeeDoctorId) {
        System.out.println(SeeDoctorId);
        //修改条件
        UpdateWrapper<SeeDoctor> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("see_doctor_id", SeeDoctorId);

        int result = seeDoctorMapper.delete(UpdateWrapper);
        System.out.println(result);
    }
}
