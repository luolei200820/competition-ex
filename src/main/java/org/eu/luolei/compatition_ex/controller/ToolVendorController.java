package org.eu.luolei.compatition_ex.controller;

import org.eu.luolei.compatition_ex.pojo.Result;
import org.eu.luolei.compatition_ex.pojo.ToolVendor;
import org.eu.luolei.compatition_ex.service.ToolVendorService;
import org.eu.luolei.compatition_ex.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tool-vendor")
public class ToolVendorController {
    @Autowired
    private ToolVendorService toolVendorService;

    @PostMapping
    public Result<ToolVendor> add(@RequestBody ToolVendor toolVendor) {
        // 1. 查找供应商名称是否重复
        ToolVendor tv = toolVendorService.getToolVendorByName(toolVendor.getName());
        if (tv != null) {
            return Result.error("供应商名称重复了");
        }

        // 获取userId
        Integer userId = ThreadLocalUtil.get();

        // 填充toolCategory并保存
        toolVendor.setCreateUserId(userId);
        toolVendor.setCreateTime(LocalDateTime.now());
        toolVendorService.save(toolVendor);

        return Result.success(toolVendor);
    }

    @DeleteMapping
    public Result delete(@RequestBody ToolVendor toolVendor) {
        toolVendorService.removeById(toolVendor);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<ToolVendor>> list() {
        return Result.success(toolVendorService.list());
    }

    @PatchMapping
    public Result update(@RequestBody ToolVendor ToolVendor) {
        ToolVendor tv = toolVendorService.getById(ToolVendor.getId());
        if (!tv.getName().equals(ToolVendor.getName())) {
            // 修改了名称，查找名称是否重复
            if (toolVendorService.getToolVendorByName(ToolVendor.getName()) != null) {
                return Result.error("名称重复了");
            }
        }

        toolVendorService.updateById(ToolVendor);
        return Result.success();
    }
}
