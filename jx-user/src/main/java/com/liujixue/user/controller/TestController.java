package com.liujixue.user.controller;

import com.liujixue.bean.Result;
import com.liujixue.redis.util.RedisShareLockUtil;
import com.liujixue.user.entity.dto.UserDto;
import com.liujixue.user.entity.req.UserListReq;
import com.liujixue.user.entity.req.UserReq;
import com.liujixue.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @Author LiuJixue
 * @Date 2023/9/10 22:55
 * @ClassName: TestController
 * @Description: 测试 Controller
 */
@RestController
@RequestMapping("/test")
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
