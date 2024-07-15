package org.eu.luolei.compatition_ex.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eu.luolei.compatition_ex.mapper.ToolMapper;
import org.eu.luolei.compatition_ex.pojo.Tool;
import org.eu.luolei.compatition_ex.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolServiceImpl extends ServiceImpl<ToolMapper, Tool> implements ToolService {
    @Autowired
    private ToolMapper toolMapper;

    @Override
    public Tool getToolByName(String name) {
        LambdaQueryWrapper<Tool> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Tool::getName, name);
        return getOne(wrapper);
    }

    @Override
    public List<Tool> toolList() {
        return toolMapper.list();
    }

    @Override
    public Tool getToolById(Integer id) {
        return toolMapper.getToolById(id);
    }
}
