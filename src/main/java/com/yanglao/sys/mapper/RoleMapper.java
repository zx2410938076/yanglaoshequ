package com.yanglao.sys.mapper;

import com.yanglao.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张旭
 * @since 2023-02-18
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> queryByUserId(int userId);
}
