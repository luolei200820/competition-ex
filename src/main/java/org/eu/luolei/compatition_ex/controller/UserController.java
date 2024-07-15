package org.eu.luolei.compatition_ex.controller;

import org.eu.luolei.compatition_ex.pojo.Result;
import org.eu.luolei.compatition_ex.pojo.User;
import org.eu.luolei.compatition_ex.service.UserService;
import org.eu.luolei.compatition_ex.utils.JwtUtil;
import org.eu.luolei.compatition_ex.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<String> register(@RequestBody User user) {
        // 1. 查找用户名是否被注册了
        User exUser = userService.getUserByUsername(user.getUsername());
        if (exUser != null) {
            return Result.error("用户名已经注册了");
        }

        // 2. 注册
        userService.save(user);

        // 3. 签发token
        String token = JwtUtil.genUserToken(user.getId(), user.getUsername());
        return Result.success(token);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {
        User exUser = userService.getUserByUsername(user.getUsername());

        if (exUser == null || !exUser.getPassword().equals(user.getPassword())) {
            return Result.error("用户名或者密码错误");
        }

        String token = JwtUtil.genUserToken(exUser.getId(), exUser.getUsername());
        return Result.success(token);
    }

    @GetMapping("/profile")
    public Result<User> profile() {
        Integer userId = ThreadLocalUtil.get();

        User user = userService.getById(userId);
        user.setPassword(null);

        return Result.success(user);
    }

    @PatchMapping("/profile")
    public Result<User> update(@RequestBody User user) {
        Integer userId = ThreadLocalUtil.get();
        user.setId(userId);

        userService.updateById(user);
        return Result.success(user);
    }
}
