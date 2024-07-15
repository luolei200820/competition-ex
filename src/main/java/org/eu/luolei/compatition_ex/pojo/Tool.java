package org.eu.luolei.compatition_ex.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

public class Tool {
    private Integer id;
    private String name;
    private String description;
    private Integer categoryId;
    private Integer vendorId;
    private String specs;
    private Integer number;

    @TableField(exist = false)
    private ToolCategory toolCategory;
    @TableField(exist = false)
    private ToolVendor toolVendor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ToolCategory getToolCategory() {
        return toolCategory;
    }

    public void setToolCategory(ToolCategory toolCategory) {
        this.toolCategory = toolCategory;
    }

    public ToolVendor getToolVendor() {
        return toolVendor;
    }

    public void setToolVendor(ToolVendor toolVendor) {
        this.toolVendor = toolVendor;
    }
}
