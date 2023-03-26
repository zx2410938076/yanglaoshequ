package com.yanglao.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanglao.sys.entity.SysUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface ISysUserService extends IService<SysUser> {

    List<SysUser> queryByUserName(String username);
}
