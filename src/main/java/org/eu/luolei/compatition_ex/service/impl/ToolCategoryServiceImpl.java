package org.eu.luolei.compatition_ex.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eu.luolei.compatition_ex.mapper.ToolCategoryMapper;
import org.eu.luolei.compatition_ex.pojo.ToolCategory;
import org.eu.luolei.compatition_ex.service.ToolCategoryService;
import org.springframework.stereotype.Service;

@Service
public class ToolCategoryServiceImpl extends ServiceImpl<ToolCategoryMapper, ToolCategory> implements ToolCategoryService {
    @Override
    public ToolCategory getToolCategoryByName(String name) {
        LambdaQueryWrapper<ToolCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ToolCategory::getName, name);
        return getOne(wrapper);
    }
}
