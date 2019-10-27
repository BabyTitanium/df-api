package com.dongfan.dongfanapi.untils;

import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/9/22 20:31
 * @Version 1.0
 */
public class PageResult {
    List list;
    int count;
    int page;
    int pageSize;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
