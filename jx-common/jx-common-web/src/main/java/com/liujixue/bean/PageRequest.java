package com.liujixue.bean;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author LiuJixue
 * @Date 2023/9/12 11:19
 * @ClassName: PageRequest
 * @Description: 请求参数
 */
@Setter
public class PageRequest implements Serializable {

    private Long pageNo = 1L;
    private Long pageSize = 10L;

    public Long getPageNo(){
        if(pageNo == null || pageNo <1L){
            return 1L;
        }
        return pageNo;
    }

    public Long getPageSize(){
        if(pageSize == null || pageSize<1L || pageSize >Integer.MAX_VALUE){
            return 10L;
        }
        return pageSize;
    }
}
