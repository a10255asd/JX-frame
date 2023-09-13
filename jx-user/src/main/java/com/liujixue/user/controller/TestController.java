package com.liujixue.user.controller;

import com.liujixue.redis.util.RedisShareLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Author LiuJixue
 * @Date 2023/9/10 22:55
 * @ClassName: TestController
 * @Description: 测试 Controller
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    private RedisShareLockUtil redisShareLockUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/testRedis")
    public void testRedis(){
        redisTemplate.opsForValue().set("name","liujixue");
    }

    @GetMapping("/testRedisLock")
    public void testRedisLock(){
        redisShareLockUtil.lock("liujixue","1121",100000L);
    }
}
