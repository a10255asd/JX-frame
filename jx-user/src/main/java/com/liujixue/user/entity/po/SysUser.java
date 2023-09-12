package com.liujixue.user.entity.po;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-09-12 16:47:23
 */
@Data
public class SysUser implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer version;


}

