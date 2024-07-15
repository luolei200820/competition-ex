package org.eu.luolei.compatition_ex.controller;

import org.eu.luolei.compatition_ex.pojo.Result;
import org.eu.luolei.compatition_ex.pojo.Tool;
import org.eu.luolei.compatition_ex.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tool")
public class ToolController {
    @Autowired
    private ToolService toolService;

    @PostMapping
    public Result<Tool> add(@RequestBody Tool tool) {
        // 1. 查找名称是否重复
        Tool t = toolService.getToolByName(tool.getName());
        if (t != null) {
            return Result.error("名称重复了");
        }

        // 校验数量是否大于等于0
        if (tool.getNumber() <= 0) {
            return Result.error("数量需要大于等于0");
        }

        toolService.save(tool);
        Tool newTool = toolService.getToolById(tool.getId());
        return Result.success(newTool);
    }

    @DeleteMapping
    public Result delete(@RequestBody Tool tool) {
        if (toolService.removeById(tool)) {
            return Result.success();
        } else {
            return Result.error("删除失败");
        }
    }

    @GetMapping("/list")
    public Result<List<Tool>> list() {
        return Result.success(toolService.toolList());
    }

    @PatchMapping
    public Result update(@RequestBody Tool tool) {
        Tool t = toolService.getById(tool.getId());
        if (!t.getName().equals(tool.getName())) {
            if (toolService.getToolByName(tool.getName()) != null) {
                return Result.error("名称重复了");
            }
        }
        toolService.updateById(tool);
        return Result.success();
    }
}
