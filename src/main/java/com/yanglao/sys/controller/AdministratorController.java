package com.yanglao.sys.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.common.vo.constant.SystemConstant;
import com.yanglao.config.JWTUtils;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张旭
 * @since 2023-04-21
 */
@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/getName")
    public Result<SysUser> getUser(String Authorization) {
        String token = Authorization.replace(SystemConstant.SYS_TOKEN_PREFIX, "");
        DecodedJWT verify = JWTUtils.verify(token);
        String userName = verify.getClaim("username").asString();

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", userName);
        SysUser user = userMapper.selectOne( queryWrapper);

        return Result.success(user, "查询成功");
    }


    //分页呈现
    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/paging")

    public Result<Page<SysUser>> getAllUser1(long current, long size) {
        Page<SysUser> page = new Page<>(current, size);

        System.out.println("前"+page);
        userMapper.selectPage(page, null);
        System.out.println("后"+page);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<SysUser>> SerchUser1(long current, long size, String target) {
        Page<SysUser> page = new Page<>(current, size);

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        userMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateUser(@RequestBody SysUser SysUser) {
        System.out.println(SysUser);
        //修改条件
        UpdateWrapper<SysUser> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("user_id", SysUser.getUserId());

        int result = userMapper.update(SysUser, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertUser(@RequestBody SysUser SysUser) {
        System.out.println(SysUser);
        int result = userMapper.insert(SysUser);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateUser(Integer userId) {
        System.out.println(userId);
        //修改条件
        UpdateWrapper<SysUser> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("user_id", userId);

        int result = userMapper.delete(userUpdateWrapper);
        System.out.println(result);
    }


    @GetMapping("/Reacquire")
    public Result Reacquire(String userName) {
        System.out.println(userName);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        List a =  userMapper.selectList(queryWrapper);
        //System.out.println(page);
        return Result.success(a, "查询成功");
    }
}
