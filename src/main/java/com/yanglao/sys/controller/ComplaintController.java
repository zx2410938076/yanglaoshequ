package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.Complaint;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.ComplaintMapper;
import com.yanglao.sys.mapper.SysUserMapper;
import com.yanglao.sys.service.IComplaintService;
import com.yanglao.sys.service.impl.ComplaintServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 * 投诉
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {
    //分页呈现
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    IComplaintService complaintService;

    @GetMapping("/paging")

    public Result<Page<Complaint>> getAllComplaint(long current, long size) {
        Page<Complaint> page = new Page<>(current, size);

        complaintMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<Complaint>> SerchComplaint(long current, long size, String target,String state,String authority) {
        if(authority.equals("doctor")){
            authority="医院";
        }
        else if(authority.equals("canteen")){
            authority="食堂";
        }
        else {
            authority="";
        }

        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        List<SysUser> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        target = String.valueOf(users.get(0).getUserId());

        Page<Complaint> page = new Page<>(current, size);
        Page<Complaint> complaintPage = complaintService.queryAllComplaint(page,target,state,authority);

//        Map<String,Object> data = new HashMap<>();
//        data.put("current",complaintPage.getTotal());
//        data.put("size",complaintPage.getRecords());


        System.out.println(complaintPage);
//        QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
//        if(target.equals("")) {//输入为空
//            if(authority.equals("doctor")){
//                queryWrapper.eq("complaint_department","医院");
//            }
//            else if(authority.equals("canteen")){
//                queryWrapper.eq("complaint_department","食堂");
//
//            }
//            if (state.equals("0")) {//为查未处理
//                queryWrapper.isNull("complaint_feedback");
//            }else if(state.equals("1")){
//                queryWrapper.isNotNull("complaint_feedback");
//            }
//            complaintMapper.selectPage(page, queryWrapper);
//            //System.out.println(page);
//            return Result.success(page, "查询成功");
//        }
//
//        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.like("user_name", target)
//                .or()
//                .eq("user_id", target);
//        List<SysUser> users = userMapper.selectList(userQueryWrapper);
//        System.out.println(users);
//        String user = String.valueOf(users.get(0).getUserId());
//
//        if(authority.equals("doctor")){
//            queryWrapper.eq("complaint_department","医院");
//
//        }//为食堂权限
//        else if(authority.equals("canteen")){
//            queryWrapper.eq("complaint_department","食堂");
//        }
//        if (state.equals("0")) {//为查未处理
//            queryWrapper.isNull("complaint_feedback");
//        }else if(state.equals("1")){
//            queryWrapper.isNotNull("complaint_feedback");
//        }
//        queryWrapper.eq("user_id", user);
//        complaintMapper.selectPage(page, queryWrapper);
//        //System.out.println(page);
        return Result.success(complaintPage, "查询成功");

    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateComplaint(@RequestBody Complaint Complaint) {
        System.out.println(Complaint);
        //修改条件
        UpdateWrapper<Complaint> ComplaintUpdateWrapper = new UpdateWrapper<>();
        ComplaintUpdateWrapper.eq("complaint_id", Complaint.getComplaintId());

        int result = complaintMapper.update(Complaint, ComplaintUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertComplaint(@RequestBody Complaint Complaint) {
        System.out.println(Complaint);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", Complaint.getUserId());
        SysUser user = userMapper.selectOne(queryWrapper);
        Complaint.setUserName(user.getUserName());
        int result = complaintMapper.insert(Complaint);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateUser(Integer complaintId) {
        System.out.println(complaintId);
        //修改条件
        UpdateWrapper<Complaint> ComplaintUpdateWrapper = new UpdateWrapper<>();
        ComplaintUpdateWrapper.eq("complaint_id", complaintId);

        int result = complaintMapper.delete(ComplaintUpdateWrapper);
        System.out.println(result);
    }

}
