package org.eu.luolei.compatition_ex.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.eu.luolei.compatition_ex.pojo.Tool;

import java.util.List;

public interface ToolService extends IService<Tool> {
    Tool getToolByName(String name);
    Tool getToolById(Integer id);

    List<Tool> toolList();
}
