package com.yanglao.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.common.vo.Result;
import com.yanglao.sys.entity.Abnormal;
import com.yanglao.sys.entity.Dish;
import com.yanglao.sys.entity.DoctorAdvice;
import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.mapper.AbnormalMapper;
import com.yanglao.sys.mapper.DishMapper;
import com.yanglao.sys.mapper.DoctorAdviceMapper;
import com.yanglao.sys.mapper.SysUserMapper;
import com.yanglao.sys.service.IDishService;
import com.yanglao.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张旭
 * @since 2023-03-27
 * 菜品信息
 */
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private DoctorAdviceMapper doctorAdviceMapper;

    @Autowired
    private IDishService dishService;

    @GetMapping("/all")
    public Result<List<Dish>> getAllUser() {
        List<Dish> list = dishService.list();
        return Result.success(list, "查询成功");
    }
    @GetMapping("/paging")

    public Result<Page<Dish>> getAllRequest(long current, long size,String authority,String state) {
        Page<Dish> page = new Page<>(current, size);
        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();

        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar=Calendar.getInstance();
        System.out.println("今天是中国的"+weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1]);

        queryWrapper.like("week",weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1]);


        if(authority.equals("canteen")){
            dishMapper.selectPage(page, null);
            return Result.success(page, "查询成功");
        }
        //得到用户信息 筛选忌口和爱吃
        QueryWrapper<SysUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_id", authority);
        SysUser user = userMapper.selectOne(userQueryWrapper);
        System.out.println(user);
        if(user.getUserForbiddenFood().length()>0){
            String[] userForbiddenFood = user.getUserForbiddenFood().split(",");
            for(String e: userForbiddenFood){//查找条件筛出忌口
                queryWrapper.notLike("raw_material",e);
            }
        }

        //得到医生建议
        QueryWrapper<DoctorAdvice> adviceQueryWrapper = new QueryWrapper<>();
        adviceQueryWrapper.eq("state", 1);
        adviceQueryWrapper.eq("user_id", authority);
        DoctorAdvice advice = doctorAdviceMapper.selectOne(adviceQueryWrapper);
        System.out.println(advice);


        if(state.equals("推荐")){
            if(advice != null){
                if(user.getUserFood() != null && advice.getIngredientRecommendation().length() > 0){
                    String[] ingredientRecommendation = advice.getIngredientRecommendation().split(",");
                    queryWrapper.and(qw -> {
                        qw.and(wq -> {
                            if(user.getUserFood() != null){
                                String[] userFood = user.getUserFood().split(",");
                                for(String e: userFood){
                                    wq.like("dish_name",e).or();//爱吃
                                }
                            }
                            if(ingredientRecommendation.length > 0){
                                for(String e: ingredientRecommendation){
                                    wq.like("raw_material",e).or();//建议食用
                                }
                            }
                        });
                    });
                }
            }



//            queryWrapper.and(qw -> {
//                        if(user.getUserFood() != null){
//                            String[] userFood = user.getUserFood().split(",");
//                            qw.and(wq -> {
//                                for(String e: userFood){
//                                    wq.like("dish_name",e).or();
//                                }
//                            });
//                        }
//                        if(ingredientRecommendation.length > 0){
//                            qw.and(wq -> {
//                                for(String e: ingredientRecommendation){
//                                    wq.like("raw_material",e).or();
//                                }
//                            });
//                        }
//                    });

            //爱吃
//            queryWrapper.and(qw -> {
//                        if(user.getUserFood() != null){
//                            String[] userFood = user.getUserFood().split(",");
//                            qw.and(wq -> {
//                                for(String e: userFood){
//                                    wq.like("dish_name",e);
//                                }
//                            });
//                        }
//                    });


//
//            if(user.getUserFood() != null){
//                String[] userFood = user.getUserFood().split(",");
//                for(String e: userFood){//查找条件筛出爱吃
//                    queryWrapper.like("dish_name",e).or();
//                }
//            }
//
//            for(String e: ingredientRecommendation){//查找条件筛出建议食用
//                queryWrapper.like("raw_material",e).or();
//                System.out.println(e);
//            }
        }else if(!state.equals("总览")){
            queryWrapper.like("dish_type",state);
        }
        dishMapper.selectPage(page, queryWrapper);
        return Result.success(page, "查询成功");
    }

    //按需查找
    @GetMapping("/search")
    public Result<Page<Dish>> Search(long current, long size, String target, String authority) {

        Page<Dish> page = new Page<>(current, size);
        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();


        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar=Calendar.getInstance();
        System.out.println("今天是中国的"+weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1]);

        if(!authority.equals("canteen")){
            queryWrapper.like("week",weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1]);
        }


        if(target.equals("")) {
            dishMapper.selectPage(page, null);
            return Result.success(page, "查询成功");
        }

        queryWrapper.like("dish_name",target);
        dishMapper.selectPage(page, queryWrapper);
        //System.out.println(page);
        return Result.success(page, "查询成功");
    }

    //@CrossOrigin
    //更新
    @PostMapping("/update")
    public void UpdateUser(@RequestBody Dish dish) {
        System.out.println(dish);
        //修改条件
        UpdateWrapper<Dish> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("dish_id", dish.getDishId());

        int result = dishMapper.update(dish, userUpdateWrapper);
        System.out.println(result);
    }

    @PostMapping("/insert")
    public void InsertUser(@RequestBody Dish Dish) {
        System.out.println(Dish);
        int result = dishMapper.insert(Dish);
        System.out.println(result);
    }

    @GetMapping("/delete")
    public void UpdateUser(Integer dishId) {
        System.out.println(dishId);
        //修改条件
        UpdateWrapper<Dish> UpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper.eq("dish_id", dishId);

        int result = dishMapper.delete(UpdateWrapper);
        System.out.println(result);
    }
}
