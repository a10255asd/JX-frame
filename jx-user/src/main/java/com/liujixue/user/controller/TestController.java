package com.liujixue.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LiuJixue
 * @Date 2023/9/10 22:55
 * @ClassName: TestController
 * @Description: 测试 Controller
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "hello world!";
    }
}
