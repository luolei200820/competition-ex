package org.eu.luolei.compatition_ex.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.eu.luolei.compatition_ex.pojo.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
