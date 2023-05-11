package com.yanglao.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.Request;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface IRequestService extends IService<Request> {

    Page<Request> queryRequest(Page<Request> page, String target);
}
