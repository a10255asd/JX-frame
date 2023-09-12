package com.liujixue.user.entity.dto;

import lombok.Data;

/**
 * @Author LiuJixue
 * @Date 2023/9/11 16:03
 * @ClassName: UserDto
 */
@Data
public class UserDto {
    private Long id;
    private String name;
    private Integer age;

    private Integer pageIndex;
    private Integer pageSize;

}
