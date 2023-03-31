package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.Disease;
import com.yanglao.sys.entity.DoctorAdvice;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.DiseaseMapper;
import com.yanglao.sys.mapper.DoctorAdviceMapper;
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
 * 病史
 */
@RestController
@RequestMapping("/disease")
public class DiseaseController {
    @Autowired
    private DiseaseMapper diseaseMapper;
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/paging")

    public Result<Page<Disease>> getAllRequest(long current, long size) {
        Page<Disease> page = new Page<>(current, size);

        diseaseMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<Disease>> SerchRequest(long current, long size, String target, String state) {

        Page<Disease> page = new Page<>(current, size);
        if(target.equals("")) {
            diseaseMapper.selectPage(page, null);
            return Result.success(page, "查询成功");
        }

        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        List<SysUser> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        String user = String.valueOf(users.get(0).getUserId());

        QueryWrapper<Disease> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user);
        diseaseMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateUser(@RequestBody Disease disease) {
        System.out.println(disease);
        //修改条件
        UpdateWrapper<Disease> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("disease_id", disease.getDiseaseId());

        int result = diseaseMapper.update(disease, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertUser(@RequestBody Disease Disease) {
        System.out.println(Disease);
        int result = diseaseMapper.insert(Disease);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateUser(Integer diseaseId) {
        System.out.println(diseaseId);
        //修改条件
        UpdateWrapper<Disease> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("disease_id", diseaseId);

        int result = diseaseMapper.delete(UpdateWrapper);
        System.out.println(result);
    }
}
