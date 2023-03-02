package com.yanglao.sys.service;

import com.yanglao.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张旭
 * @since 2023-02-18
 */
public interface IRoleService extends IService<Role> {
    List<Role> queryByUserId(int userId);
}
