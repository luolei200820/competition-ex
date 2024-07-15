package org.eu.luolei.compatition_ex.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eu.luolei.compatition_ex.mapper.ToolVendorMapper;
import org.eu.luolei.compatition_ex.pojo.ToolVendor;
import org.eu.luolei.compatition_ex.service.ToolVendorService;
import org.springframework.stereotype.Service;

@Service
public class ToolVendorServiceImpl extends ServiceImpl<ToolVendorMapper, ToolVendor> implements ToolVendorService {
    @Override
    public ToolVendor getToolVendorByName(String name) {
        LambdaQueryWrapper<ToolVendor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ToolVendor::getName,name);
        return getOne(wrapper);
    }
}
