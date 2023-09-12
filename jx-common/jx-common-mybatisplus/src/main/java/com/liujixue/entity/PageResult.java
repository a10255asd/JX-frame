package com.liujixue.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Author LiuJixue
 * @Date 2023/9/12 10:05
 * @ClassName: PageResult
 * @Description: 统一分页格式
 */
@Data
public class PageResult<T> implements Serializable {
    private Long total;
    private Long size;
    private Long current;
    private Long pages;
    private List<T> records = Collections.emptyList();
    public void loadData(IPage<T> pageData){
        this.setCurrent(pageData.getCurrent());
        this.setPages(pageData.getPages());
        this.setSize(pageData.getSize());
        this.setTotal(pageData.getTotal());
        this.setRecords(pageData.getRecords());
    }
}
