package org.eu.luolei.compatition_ex.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.eu.luolei.compatition_ex.pojo.ToolCategory;

public interface ToolCategoryService extends IService<ToolCategory>{
    ToolCategory getToolCategoryByName(String name);
}
