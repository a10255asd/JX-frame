package com.liujixue.user.controller;

import com.liujixue.bean.PageRequest;
import com.liujixue.bean.PageResponse;
import com.liujixue.bean.Result;
import com.liujixue.user.entity.po.SysUser;
import com.liujixue.user.entity.req.SysUserReq;
import com.liujixue.user.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2023-09-12 16:47:22
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询
     *
     * @param sysUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public Result<PageResponse<SysUser>> queryByPage(SysUserReq sysUserReq) {
        return Result.ok(this.sysUserService.queryByPage(sysUserReq));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<SysUser> queryById(@PathVariable("id") Long id) {
        return Result.ok(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<SysUser> add(SysUser sysUser) {
        return Result.ok(this.sysUserService.insert(sysUser));
    }

    /**
     * 编辑数据
     *
     * @param sysUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result<SysUser> edit(SysUser sysUser) {
        return Result.ok(this.sysUserService.update(sysUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result<Boolean> deleteById(Long id) {
        return Result.ok(this.sysUserService.deleteById(id));
    }

}
