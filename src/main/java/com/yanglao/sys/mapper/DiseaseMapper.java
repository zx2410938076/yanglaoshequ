package com.yanglao.sys.mapper;

import com.yanglao.sys.entity.Disease;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张旭
 * @since 2023-03-18
 */
public interface DiseaseMapper extends BaseMapper<Disease> {
    @Select("SELECT disease, COUNT(*) AS count FROM disease GROUP BY disease ORDER BY COUNT(*) DESC")

    List<Map<String, Object>> countDisease();
}
