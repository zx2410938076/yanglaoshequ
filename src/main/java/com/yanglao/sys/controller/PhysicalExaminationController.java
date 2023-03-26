package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.assist.ISqlRunner;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.PhysicalExamination;
import com.yanglao.sys.entity.Request;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.PhysicalExaminationMapper;
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
@RequestMapping("/physicalExamination")
public class PhysicalExaminationController {

    @Autowired
    private PhysicalExaminationMapper physicalExaminationMapper;
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/paging")

    public Result<Page<PhysicalExamination>> getAllRequest(long current, long size) {
        Page<PhysicalExamination> page = new Page<>(current, size);

        physicalExaminationMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<PhysicalExamination>> SerchRequest(long current, long size, String target, String state) {

        Page<PhysicalExamination> page = new Page<>(current, size);
        if(target.equals("")) {
            physicalExaminationMapper.selectPage(page, null);
            return Result.success(page, "查询成功");
        }

        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        List<SysUser> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        String user = String.valueOf(users.get(0).getUserId());

        QueryWrapper<PhysicalExamination> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user);
        physicalExaminationMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateUser(@RequestBody PhysicalExamination PhysicalExamination) {
        System.out.println(PhysicalExamination);
        //修改条件
        UpdateWrapper<PhysicalExamination> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("physical_examination_id", PhysicalExamination.getPhysicalExaminationId());

        int result = physicalExaminationMapper.update(PhysicalExamination, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertUser(@RequestBody PhysicalExamination PhysicalExamination) {
        System.out.println(PhysicalExamination);
        int result = physicalExaminationMapper.insert(PhysicalExamination);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateUser(Integer PhysicalExaminationId) {
        System.out.println(PhysicalExaminationId);
        //修改条件
        UpdateWrapper<PhysicalExamination> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("physical_examination_id", PhysicalExaminationId);

        int result = physicalExaminationMapper.delete(userUpdateWrapper);
        System.out.println(result);
    }
}
