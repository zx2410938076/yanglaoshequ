package com.yanglao.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yanglao.sys.entity.SeeDoctor;
import com.yanglao.sys.mapper.SeeDoctorMapper;
import com.yanglao.sys.service.ISeeDoctorService;
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
public class SeeDoctorServiceImpl extends ServiceImpl<SeeDoctorMapper, SeeDoctor> implements ISeeDoctorService {

    @Autowired
    private SeeDoctorMapper seeDoctorMapper;
    @Override
    public Page<SeeDoctor> querySeeDoctor(Page<SeeDoctor> page, String target) {
        return seeDoctorMapper.querySeeDoctor(page,target);
    }
}
