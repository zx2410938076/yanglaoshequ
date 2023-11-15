package com.yanglao.sys.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.MakeAppointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanglao.sys.entity.Request;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface MakeAppointmentMapper extends BaseMapper<MakeAppointment> {

    Page<MakeAppointment> queryAppointment(Page<MakeAppointment> page, String target, String state, String day);
}
