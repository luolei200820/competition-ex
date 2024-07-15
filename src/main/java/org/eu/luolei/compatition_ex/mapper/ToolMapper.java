package org.eu.luolei.compatition_ex.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.eu.luolei.compatition_ex.pojo.Tool;

import java.util.List;

@Mapper
public interface ToolMapper extends BaseMapper<Tool> {
    List<Tool> list();

    Tool getToolById(Integer id);
}
