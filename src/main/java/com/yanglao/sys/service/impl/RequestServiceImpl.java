package com.yanglao.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.Request;
import com.yanglao.sys.mapper.RequestMapper;
import com.yanglao.sys.service.IRequestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
@Service
public class RequestServiceImpl extends ServiceImpl<RequestMapper, Request> implements IRequestService {

    @Autowired
    RequestMapper requestMapper;
    @Override
    public Page<Request> queryRequest(Page<Request> page, String target) {
        return requestMapper.queryRequest(page,target);
    }
}
