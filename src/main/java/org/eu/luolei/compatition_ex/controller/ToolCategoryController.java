package org.eu.luolei.compatition_ex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.eu.luolei.compatition_ex.pojo.Result;
import org.eu.luolei.compatition_ex.pojo.ToolCategory;
import org.eu.luolei.compatition_ex.service.ToolCategoryService;
import org.eu.luolei.compatition_ex.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tool-category")
public class ToolCategoryController {
    @Autowired
    private ToolCategoryService toolCategoryService;

    @PostMapping
    public Result<ToolCategory> add(@RequestBody ToolCategory toolCategory) {
        // 1. 查找分类名称是否重复
        ToolCategory tc = toolCategoryService.getToolCategoryByName(toolCategory.getName());
        if (tc != null) {
            return Result.error("分类名称重复了");
        }

        // 获取userId
        Integer userId = ThreadLocalUtil.get();

        // 填充toolCategory并保存
        toolCategory.setCreateUserId(userId);
        toolCategory.setCreateTime(LocalDateTime.now());
        toolCategoryService.save(toolCategory);

        return Result.success(toolCategory);
    }

    @GetMapping("/list")
    public Result<List<ToolCategory>> list() {
        return Result.success(toolCategoryService.list());
    }

    @PatchMapping
    public Result update(@RequestBody ToolCategory toolCategory) {
        ToolCategory tc = toolCategoryService.getById(toolCategory.getId());
        if (!tc.getName().equals(toolCategory.getName())) {
            // 修改了名称，查找名称是否重复
            if (toolCategoryService.getToolCategoryByName(toolCategory.getName()) != null) {
                return Result.error("名称重复了");
            }
        }

        toolCategoryService.updateById(toolCategory);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestBody ToolCategory toolCategory) {
        toolCategoryService.removeById(toolCategory);
        return Result.success();
    }
}
