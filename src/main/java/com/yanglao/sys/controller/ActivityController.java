package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.Activity;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.ActivityMapper;
import com.yanglao.sys.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityMapper activityMapper;

    @GetMapping("/paging")

    public Result<Page<Activity>> getAllActivity(long current, long size) {

        System.out.println("传来的数据"+current+size);
        Page<Activity> page = new Page<>(current, size);
        activityMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }


    //更新
    @PostMapping("/update")
    public void UpdateActivity(@RequestBody Activity Activity) {
        System.out.println("更新");
        System.out.println(Activity);
        //修改条件
        UpdateWrapper<Activity> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("activity_id",Activity.getActivityId());

        int result = activityMapper.update(Activity, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertActivity(@RequestBody Activity Activity) {
        System.out.println(Activity);
        int result = activityMapper.insert(Activity);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateActivity(Integer activityId) {
        System.out.println("进入删除");
        System.out.println(activityId);
        //修改条件
        UpdateWrapper<Activity> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("activity_id", activityId);

        int result = activityMapper.delete(UpdateWrapper);
        System.out.println(result);
    }

}
