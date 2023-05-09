package com.yanglao.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.Complaint;
import com.yanglao.sys.entity.ComplaintDTO;
import com.yanglao.sys.mapper.ComplaintMapper;
import com.yanglao.sys.service.IComplaintService;
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
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements IComplaintService {

    @Autowired
    ComplaintMapper complaintMapper;

    @Override
    public Page<Complaint> queryAllComplaint(Page<Complaint> page, String target, String state, String authority) {
        return complaintMapper.queryAllComplaint(page,target,state,authority);
    }
}
