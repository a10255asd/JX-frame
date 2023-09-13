package com.liujixue.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author LiuJixue
 * @Date 2023/9/10 22:50
 * @ClassName: UserApplication
 */
@SpringBootApplication
@MapperScan(value = "com.liujixue.*.dao")
@ComponentScan(value = "com.liujixue")
@EnableCaching
public class UserApplication {
    public static void main(String[] args) {
        // 异步 log
        // System.setProperty("Log4jContextSelector","org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(UserApplication.class,args);
    }
}
