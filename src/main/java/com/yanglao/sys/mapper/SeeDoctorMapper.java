package com.yanglao.sys.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.SeeDoctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface SeeDoctorMapper extends BaseMapper<SeeDoctor> {

    Page<SeeDoctor> querySeeDoctor(Page<SeeDoctor> page, String target);
}
