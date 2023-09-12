package com.liujixue.user.service;

import com.liujixue.user.entity.dto.UserDto;

/**
 * @Author LiuJixue
 * @Date 2023/9/11 16:02
 * @ClassName: UserServcie
 */
public interface UserService {
    int addUser(UserDto userDto);
}
