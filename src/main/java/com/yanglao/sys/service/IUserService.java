package com.yanglao.sys.service;

import com.yanglao.sys.entity.MyUser;
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
public interface IUserService extends IService<MyUser> {

    List<MyUser> queryByUserName(String username);
}
