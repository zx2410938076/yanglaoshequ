package com.yanglao.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.MakeAppointment;
import com.yanglao.sys.entity.Request;
import com.yanglao.sys.mapper.MakeAppointmentMapper;
import com.yanglao.sys.service.IMakeAppointmentService;
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
public class MakeAppointmentServiceImpl extends ServiceImpl<MakeAppointmentMapper, MakeAppointment> implements IMakeAppointmentService {

    @Autowired
    MakeAppointmentMapper makeAppointmentMapper;
    @Override
    public Page<MakeAppointment> queryAppointment(Page<MakeAppointment> page, String state, String target,String day) {
        return makeAppointmentMapper.queryAppointment(page,target,state,day);
    }
}
