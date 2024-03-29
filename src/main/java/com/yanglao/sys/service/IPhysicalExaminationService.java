package com.yanglao.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.PhysicalExamination;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface IPhysicalExaminationService extends IService<PhysicalExamination> {

    Page<PhysicalExamination> queryPhysicalExamination(Page<PhysicalExamination> page, String target);
}
