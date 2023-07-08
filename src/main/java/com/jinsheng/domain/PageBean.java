package com.jinsheng.domain;

import java.util.List;

//用于分页查询的javaBean
public class PageBean<T> {
    //记录总数
    private int totalCount;

    //当前页数据
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
