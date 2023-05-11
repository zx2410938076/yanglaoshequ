package com.yanglao.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.SeeDoctor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface ISeeDoctorService extends IService<SeeDoctor> {

    Page<SeeDoctor> querySeeDoctor(Page<SeeDoctor> page, String target);
}
