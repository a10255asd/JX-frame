package com.liujixue.user.service;

import com.liujixue.entity.PageResult;
import com.liujixue.user.entity.dto.UserDto;
import com.liujixue.user.entity.po.UserPo;

/**
 * @Author LiuJixue
 * @Date 2023/9/11 16:02
 * @ClassName: UserServcie
 */
public interface UserService {
    int addUser(UserDto userDto);

    int delete(Integer id);

    PageResult<UserPo> getUserPage(UserDto userDto);
}
