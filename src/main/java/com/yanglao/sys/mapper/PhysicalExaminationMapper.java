package com.yanglao.sys.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.PhysicalExamination;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface PhysicalExaminationMapper extends BaseMapper<PhysicalExamination> {

    Page<PhysicalExamination> queryPhysicalExamination(Page<PhysicalExamination> page, String target);
}
