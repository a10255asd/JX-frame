package com.liujixue.user.controller;

import com.liujixue.user.entity.dto.UserDto;
import com.liujixue.user.entity.req.UserReq;
import com.liujixue.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author LiuJixue
 * @Date 2023/9/10 22:55
 * @ClassName: TestController
 * @Description: 测试 Controller
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public Integer addUser(@RequestBody UserReq userReq){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq,userDto);
        int i = userService.addUser(userDto);
        return i;
    }
}
