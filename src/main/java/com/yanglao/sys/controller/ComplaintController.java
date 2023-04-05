package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.Complaint;
import com.yanglao.sys.entity.Request;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.ComplaintMapper;
import com.yanglao.sys.mapper.RequestMapper;
import com.yanglao.sys.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @GetMapping("/paging")

    public Result<Page<Complaint>> getAllComplaint(long current, long size) {
        Page<Complaint> page = new Page<>(current, size);

        complaintMapper.selectPage(page, null);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<Complaint>> SerchComplaint(long current, long size, String target,String state,String authority) {

        Page<Complaint> page = new Page<>(current, size);
        if(target.equals("")) {//输入为空
            if (authority.equals("community")) {//身份为社区管理员
                if (state.equals("0")) {//为查未处理

                    QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("complaint_feedback", "");
                    complaintMapper.selectPage(page, queryWrapper);
                    //System.out.println(page);
                    return Result.success(page, "查询成功");
                }
                QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
                queryWrapper.ne("complaint_feedback", "");
                complaintMapper.selectPage(page, queryWrapper);
                //System.out.println(page);
                return Result.success(page, "查询成功");
            }
            else if(authority.equals("doctor")){
                if (state.equals("0")) {//为查未处理

                    QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
                    queryWrapper.isNull("complaint_feedback")
                                .eq("complaint_department","医院");
                    complaintMapper.selectPage(page, queryWrapper);
                    //System.out.println(page);
                    return Result.success(page, "查询成功");
                }
                QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
                queryWrapper.isNotNull("complaint_feedback")
                            .eq("complaint_department","医院");
                complaintMapper.selectPage(page, queryWrapper);
                //System.out.println(page);
                return Result.success(page, "查询成功");

            }
            else if(authority.equals("canteen")){
                if (state.equals("0")) {//为查未处理

                    QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
                    queryWrapper.isNull("complaint_feedback")
                            .eq("complaint_department","食堂");
                    complaintMapper.selectPage(page, queryWrapper);
                    //System.out.println(page);
                    return Result.success(page, "查询成功");
                }
                QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
                queryWrapper.isNotNull("complaint_feedback")
                        .eq("complaint_department","食堂");
                complaintMapper.selectPage(page, queryWrapper);
                //System.out.println(page);
                return Result.success(page, "查询成功");

            }
        }

        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name", target)
                .or()
                .eq("user_id", target);
        List<SysUser> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
        String user = String.valueOf(users.get(0).getUserId());

        if (authority.equals("community")) {//身份为社区管理员
            if (state.equals("0")) {//为查未处理

                QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("complaint_feedback", "")
                            .eq("user_id", user);
                complaintMapper.selectPage(page, queryWrapper);
                //System.out.println(page);
                return Result.success(page, "查询成功");
            }
            QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
            queryWrapper.ne("complaint_feedback", "")
                        .eq("user_id", user);
            complaintMapper.selectPage(page, queryWrapper);
            //System.out.println(page);
            return Result.success(page, "查询成功");
        }
        else if(authority.equals("doctor")){
            if (state.equals("0")) {//为查未处理

                QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
                queryWrapper.isNull("complaint_feedback")
                        .eq("complaint_department","医院")
                        .eq("user_id", user);
                complaintMapper.selectPage(page, queryWrapper);
                //System.out.println(page);
                return Result.success(page, "查询成功");
            }
            QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
            queryWrapper.isNotNull("complaint_feedback")
                    .eq("complaint_department","医院")
                    .eq("user_id", user);
            complaintMapper.selectPage(page, queryWrapper);
            //System.out.println(page);
            return Result.success(page, "查询成功");

        }//为食堂权限
        else if(authority.equals("canteen")){
            if (state.equals("0")) {//为查未处理
                QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
                queryWrapper.isNull("complaint_feedback")
                        .eq("complaint_department","食堂")
                        .eq("user_id", user);
                complaintMapper.selectPage(page, queryWrapper);
                //System.out.println(page);
                return Result.success(page, "查询成功");
            }
            QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
            queryWrapper.isNotNull("complaint_feedback")
                    .eq("complaint_department","食堂")
                    .eq("user_id", user);
            complaintMapper.selectPage(page, queryWrapper);
            //System.out.println(page);
            return Result.success(page, "查询成功");

        }
        if (state.equals("0")) {//为查未处理
            QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
            queryWrapper.isNull("complaint_feedback")
                    .eq("user_id", user);
            complaintMapper.selectPage(page, queryWrapper);
            //System.out.println(page);
            return Result.success(page, "查询成功");
        }else if(state.equals("1")){
            QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
            queryWrapper.isNotNull("complaint_feedback")
                    .eq("user_id", user);
            complaintMapper.selectPage(page, queryWrapper);
            //System.out.println(page);
            return Result.success(page, "查询成功");
        }
        QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user);
        complaintMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");

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
