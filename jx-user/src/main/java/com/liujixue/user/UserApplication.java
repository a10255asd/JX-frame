package com.liujixue.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author LiuJixue
 * @Date 2023/9/10 22:50
 * @ClassName: UserApplication
 */
@SpringBootApplication
@MapperScan(value = "com.liujixue.*.mapper")
@ComponentScan(value = "com.liujixue")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
