package org.eu.luolei.compatition_ex.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.eu.luolei.compatition_ex.pojo.User;

public interface UserService extends IService<User> {
    User getUserByUsername(String username);
}
