package com.yanglao.sys.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.Complaint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanglao.sys.entity.ComplaintDTO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface ComplaintMapper extends BaseMapper<Complaint> {

    Page<Complaint> queryAllComplaint(Page<Complaint> page, String target, String state, String authority);
}
