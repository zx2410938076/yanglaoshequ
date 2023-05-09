package com.yanglao.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.Complaint;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yanglao.sys.entity.ComplaintDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface IComplaintService extends IService<Complaint> {

    Page<Complaint> queryAllComplaint(Page<Complaint> page, String target, String state, String authority);
}
