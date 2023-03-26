package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.Request;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.RequestMapper;
import com.yanglao.sys.mapper.SysUserMapper;
import com.yanglao.sys.service.ISysUserService;
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
@RequestMapping("/request")
public class RequestController {

    //分页呈现
    @Autowired
    private RequestMapper requestMapper;
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/paging")

    public Result<Page<Request>> getAllRequest(long current, long size) {
        Page<Request> page = new Page<>(current, size);

        requestMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<Request>> SerchRequest(long current, long size, String target, String state) {

        Page<Request> page = new Page<>(current, size);
        if(target.equals("")) {
            requestMapper.selectPage(page, null);
            return Result.success(page, "查询成功");
        }

        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        List<SysUser> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        String user = String.valueOf(users.get(0).getUserId());

        QueryWrapper<Request> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user);
        requestMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateUser(@RequestBody Request Request) {
        System.out.println(Request);
        //修改条件
        UpdateWrapper<Request> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("request_id", Request.getRequestId());

        int result = requestMapper.update(Request, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertUser(@RequestBody Request Request) {
        System.out.println(Request);
        int result = requestMapper.insert(Request);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateUser(Integer requestId) {
        System.out.println(requestId);
        //修改条件
        UpdateWrapper<Request> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("request_id", requestId);

        int result = requestMapper.delete(userUpdateWrapper);
        System.out.println(result);
    }

}
