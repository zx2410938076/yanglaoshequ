package com.yanglao.sys.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.Request;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface RequestMapper extends BaseMapper<Request> {

    Page<Request> queryRequest(Page<Request> page, String target);
}
