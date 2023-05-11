package com.yanglao.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.PhysicalExamination;
import com.yanglao.sys.mapper.PhysicalExaminationMapper;
import com.yanglao.sys.service.IPhysicalExaminationService;
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
public class PhysicalExaminationServiceImpl extends ServiceImpl<PhysicalExaminationMapper, PhysicalExamination> implements IPhysicalExaminationService {

    @Autowired
    private PhysicalExaminationMapper physicalExaminationMapper;
    @Override
    public Page<PhysicalExamination> queryPhysicalExamination(Page<PhysicalExamination> page, String target) {
        return physicalExaminationMapper.queryPhysicalExamination(page,target);
    }
}
