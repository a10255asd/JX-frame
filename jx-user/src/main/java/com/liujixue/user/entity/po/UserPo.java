package com.liujixue.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.liujixue.entity.BaseEntity;
import lombok.Data;

/**
 * @Author LiuJixue
 * @Date 2023/9/11 10:33
 * @ClassName: User
 */
@TableName("user")
@Data
public class UserPo extends BaseEntity {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
}
