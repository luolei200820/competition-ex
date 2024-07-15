package org.eu.luolei.compatition_ex;

import org.eu.luolei.compatition_ex.mapper.ToolMapper;
import org.eu.luolei.compatition_ex.pojo.Tool;
import org.eu.luolei.compatition_ex.service.ToolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CompatitionExApplicationTests {

    @Autowired
    private ToolService toolService;

    @Test
    void contextLoads() {
    }

    private Tool buildTool(int i) {
        Tool tool = new Tool();
        tool.setId(i);
        tool.setName("工具名称" + i);
        tool.setDescription("描述" + i);
        tool.setCategoryId(2);
        tool.setVendorId(2);
        tool.setNumber(100);
        tool.setSpecs("hhhhhhhhhhh");
        return tool;
    }

    @Test
    void insertTest() {
        long begin = System.currentTimeMillis();
        List<Tool> list = new ArrayList<>(1000);
        for (int i = 1; i <= 100000; i++) {
            Tool newTool =buildTool(i);
            list.add(newTool);
            if(i%1000==0){
                toolService.saveBatch(list);
                list.clear();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin));
    }
}
