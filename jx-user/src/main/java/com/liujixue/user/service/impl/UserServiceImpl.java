package com.liujixue.user.service.impl;

import com.liujixue.user.entity.dto.UserDto;
import com.liujixue.user.entity.po.UserPo;
import com.liujixue.user.mapper.UserMapper;
import com.liujixue.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author LiuJixue
 * @Date 2023/9/11 16:18
 * @ClassName: UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(UserDto userDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto,userPo);
        int count = userMapper.insert(userPo);
        return count;
    }
}
