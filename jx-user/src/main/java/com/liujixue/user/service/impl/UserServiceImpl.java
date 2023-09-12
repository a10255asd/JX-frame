package com.liujixue.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liujixue.entity.PageResult;
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

    @Override
    public int delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public PageResult<UserPo> getUserPage(UserDto userDto) {
        IPage<UserPo> userPoIPage = new Page<>(userDto.getPageIndex(),userDto.getPageSize());
        IPage<UserPo> userPage = userMapper.getUserPage(userPoIPage);
        PageResult<UserPo> pageResult = new PageResult<>();
        pageResult.loadData(userPage);
        return pageResult;
    }
}

