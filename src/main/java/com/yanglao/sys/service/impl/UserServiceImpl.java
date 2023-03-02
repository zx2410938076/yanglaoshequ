package com.yanglao.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yanglao.common.vo.constant.SystemConstant;
import com.yanglao.sys.entity.MyUser;
import com.yanglao.sys.mapper.UserMapper;
import com.yanglao.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张旭
 * @since 2023-02-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, MyUser> implements IUserService {
    @Override
    public List<MyUser> queryByUserName(String username) {
        QueryWrapper<MyUser> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(username),"username",username);
        return this.baseMapper.selectList(wrapper);
    }
}
