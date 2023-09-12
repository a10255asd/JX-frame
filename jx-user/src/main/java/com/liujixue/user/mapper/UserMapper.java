package com.liujixue.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liujixue.user.entity.po.UserPo;
import org.springframework.stereotype.Repository;

/**
 * @Author LiuJixue
 * @Date 2023/9/11 10:31
 * @ClassName: UserMapper
 */
@Repository
public interface UserMapper extends BaseMapper<UserPo> {

}
