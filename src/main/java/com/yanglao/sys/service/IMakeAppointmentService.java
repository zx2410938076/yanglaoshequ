package com.yanglao.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.MakeAppointment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yanglao.sys.entity.Request;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface IMakeAppointmentService extends IService<MakeAppointment> {

    Page<MakeAppointment> queryAppointment(Page<MakeAppointment> page,String state, String target,String day);
}
