package com.liujixue.user.service.impl;

import com.liujixue.bean.PageResponse;
import com.liujixue.user.convert.SysUserConverter;
import com.liujixue.user.entity.po.SysUser;
import com.liujixue.user.mapper.SysUserDao;
import com.liujixue.user.entity.req.SysUserReq;
import com.liujixue.user.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-09-12 16:47:23
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Long id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    @Override
    public PageResponse<SysUser> queryByPage(SysUserReq sysUserReq) {
        SysUser sysUser = SysUserConverter.INSTANCE.convertReqSysUser(sysUserReq);
        PageResponse<SysUser> sysUserPageResponse = new PageResponse<>();
        sysUserPageResponse.setCurrent(sysUserReq.getPageNo());
        sysUserPageResponse.setPageSize(sysUserReq.getPageSize());
        long pageStart = (sysUserReq.getPageNo()-1) * sysUserReq.getPageSize();
        long total = this.sysUserDao.count(sysUser);
        List<SysUser> sysUsersList = this.sysUserDao.queryAllByLimit(sysUser, pageStart, sysUserReq.getPageSize());
        sysUserPageResponse.setTotal(total);
        sysUserPageResponse.setResult(sysUsersList);
        return sysUserPageResponse;
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserDao.deleteById(id) > 0;
    }
}
