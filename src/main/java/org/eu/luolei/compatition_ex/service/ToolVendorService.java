package org.eu.luolei.compatition_ex.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.eu.luolei.compatition_ex.pojo.ToolVendor;

public interface ToolVendorService extends IService<ToolVendor> {
    ToolVendor getToolVendorByName(String name);
}
