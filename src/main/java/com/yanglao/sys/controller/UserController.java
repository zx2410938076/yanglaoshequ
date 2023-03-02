package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.MyUser;
import com.yanglao.sys.mapper.UserMapper;
import com.yanglao.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张旭
 * @since 2023-02-18
 */
@RestController
//@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public Result<List<MyUser>> getAllUser(){
        List<MyUser> list = userService.list();
        return Result.success(list,"查询成功");
    }


    //分页呈现
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/paging")
    public Result<Page<MyUser>> getAllUser1(long current, long size){
        Page<MyUser> page = new Page<>(current,size);

        System.out.println(page);
         userMapper.selectPage(page,null);
        System.out.println(page);
        return Result.success(page,"查询成功");
    }

    //按需查找
    @GetMapping("/serch")
    public Result<Page<MyUser>> SerchUser1(long current, long size, String target){
        Page<MyUser> page = new Page<>(current,size);

        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", target)
                .or()
                .eq("id", target);
        userMapper.selectPage(page,queryWrapper);
        //System.out.println(page);
        return Result.success(page,"查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateUser(@RequestBody MyUser myUser){
        System.out.println(myUser);
        //修改条件
        UpdateWrapper<MyUser> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id", myUser.getId());

        int result = userMapper.update(myUser, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertUser(@RequestBody MyUser myUser){
        System.out.println(myUser);
        int result = userMapper.insert(myUser);
        System.out.println(result);

    }

    @GetMapping ("/delete")
    public void UpdateUser(Integer id){
        System.out.println(id);
        //修改条件
        UpdateWrapper<MyUser> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id",id);

        int result = userMapper.delete(userUpdateWrapper);
        System.out.println(result);
    }
}
