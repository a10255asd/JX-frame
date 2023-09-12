package com.liujixue.bean;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @Author LiuJixue
 * @Date 2023/9/12 11:23
 * @ClassName: PageResponse
 * @Description: 返回
 */
@Data
public class PageResponse<T> {
    private Long pageNo = 1L;

    private Long pageSize = 10L;

    private Long total = 0L;

    private Long totalPages = 0L;

    private List<T> result = Collections.emptyList();

    private Long start = 1L;

    private Long end = 0L;

    public PageResponse() {
    }

    public void setRecords(List<T> result) {
        this.result = result;
        if (result != null && result.size() > 0L && this.total == 0L) {
            setTotal(Long.valueOf(result.size()));
        }
    }

    public void setCurrent(Long pageNo) {
        if (pageNo != null && pageNo > 0L) {
            this.pageNo = pageNo;
        }
    }

    public void setPageSize(Long pageSize) {
        if (pageSize != null) {
            this.pageSize = pageSize;
        }
    }

    public void setTotal(Long total) {
        this.total = total;
        if (total == -1L) {
            this.pageNo = 1L;
            return;
        }
        if (this.pageSize > 0L) {
            this.totalPages = (total / this.pageSize) + (total % this.pageSize == 0L ? 0L : 1L);
        } else {
            this.totalPages = 0L;
        }
        this.start = (this.pageNo > 0L ? (this.pageNo - 1L) * this.pageSize : 0L) + 1L;
        this.end = (this.start - 1L + this.pageSize * (this.pageNo > 0L ? 1L : 0L));
    }

}
