package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.DoctorAdvice;
import com.yanglao.sys.entity.SeeDoctor;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.DoctorAdviceMapper;
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
 * @since 2023-03-27
 * 医生建议
 */
@RestController
@RequestMapping("/doctorAdvice")
public class DoctorAdviceController {

    @Autowired
    private DoctorAdviceMapper doctorAdviceMapper;
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/paging")

    public Result<Page<DoctorAdvice>> getAllRequest(long current, long size) {
        Page<DoctorAdvice> page = new Page<>(current, size);

        doctorAdviceMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<DoctorAdvice>> SearchRequest(long current, long size, String target) {

        Page<DoctorAdvice> page = new Page<>(current, size);
        QueryWrapper<DoctorAdvice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", 1);

        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        List<SysUser> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        String user = String.valueOf(users.get(0).getUserId());


        queryWrapper.eq("user_id", user);
        doctorAdviceMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateUser(@RequestBody DoctorAdvice doctorAdvice) {
        System.out.println(doctorAdvice);
        //修改条件
        UpdateWrapper<DoctorAdvice> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("advice_id", doctorAdvice.getAdviceId());

        int result = doctorAdviceMapper.update(doctorAdvice, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertUser(@RequestBody DoctorAdvice doctorAdvice) {
        System.out.println(doctorAdvice);
        //删除上一条的状态
        UpdateWrapper<DoctorAdvice> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("user_id", doctorAdvice.getUserId());
        userUpdateWrapper.set("state","");

        int updateResult = doctorAdviceMapper.update(null,userUpdateWrapper);

        int result = doctorAdviceMapper.insert(doctorAdvice);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateUser(Integer adviceId) {
        System.out.println(adviceId);
        //修改条件
        UpdateWrapper<DoctorAdvice> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("advice_id", adviceId);

        int result = doctorAdviceMapper.delete(UpdateWrapper);
        System.out.println(result);
    }
}
