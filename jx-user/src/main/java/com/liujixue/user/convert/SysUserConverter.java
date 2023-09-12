package com.liujixue.user.convert;

import com.liujixue.user.entity.po.SysUser;
import com.liujixue.user.entity.req.SysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserConverter {
    SysUserConverter INSTANCE = Mappers.getMapper(SysUserConverter.class);
    SysUser convertReqSysUser(SysUserReq sysUserReq);
}
