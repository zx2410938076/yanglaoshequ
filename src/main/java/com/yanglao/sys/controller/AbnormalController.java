package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.Abnormal;
import com.yanglao.sys.entity.Disease;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.AbnormalMapper;
import com.yanglao.sys.mapper.DiseaseMapper;
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
 * 异常信息
 */
@RestController
@RequestMapping("/abnormal")
public class AbnormalController {
    @Autowired
    private AbnormalMapper abnormalMapper;
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/paging")

    public Result<Page<Abnormal>> getAllRequest(long current, long size) {
        Page<Abnormal> page = new Page<>(current, size);

        abnormalMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<Abnormal>> SerchRequest(long current, long size, String target, String state) {

        Page<Abnormal> page = new Page<>(current, size);
        if(target.equals("")) {
            abnormalMapper.selectPage(page, null);
            return Result.success(page, "查询成功");
        }

        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        List<SysUser> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        String user = String.valueOf(users.get(0).getUserId());

        QueryWrapper<Abnormal> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user);
        abnormalMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateUser(@RequestBody Abnormal abnormal) {
        System.out.println(abnormal);
        //修改条件
        UpdateWrapper<Abnormal> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("abnormal_id", abnormal.getAbnormalId());

        int result = abnormalMapper.update(abnormal, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertUser(@RequestBody Abnormal Abnormal) {
        System.out.println(Abnormal);
        int result = abnormalMapper.insert(Abnormal);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateUser(Integer abnormalId) {
        System.out.println(abnormalId);
        //修改条件
        UpdateWrapper<Abnormal> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("abnormal_id", abnormalId);

        int result = abnormalMapper.delete(UpdateWrapper);
        System.out.println(result);
    }
}
