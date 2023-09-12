package com.liujixue.user.entity.req;

import lombok.Data;

/**
 * @Author LiuJixue
 * @Date 2023/9/11 16:03
 * @ClassName: UserDto
 */
@Data
public class UserReq {
    private Long id;
    private String name;
    private Integer age;
}
