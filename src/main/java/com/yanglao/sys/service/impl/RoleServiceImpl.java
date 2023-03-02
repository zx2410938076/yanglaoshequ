package com.yanglao.sys.service.impl;

import com.yanglao.sys.entity.Role;
import com.yanglao.sys.mapper.RoleMapper;
import com.yanglao.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper RoleMapper;
    @Override
    public List<Role> queryByUserId(int userId) {
        return RoleMapper.queryByUserId(userId);
    }
}
