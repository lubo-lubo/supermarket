package com.lubo.util;

import com.lubo.vo.Vbill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageUtil<T> {
    private int totalCount;
    private int pageNo;
    private int item;
    private int pageSize;
    private int maxPage;
    private List<T> lists;

    public PageUtil() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getItem() {
        return (pageNo-1)*pageSize;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getMaxPage() {
        return (int) Math.ceil((double) totalCount/(double)pageSize);
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "totalCount=" + totalCount +
                ", pageNo=" + pageNo +
                ", item=" + item +
                ", pageSize=" + pageSize +
                ", maxPage=" + maxPage +
                ", lists=" + lists +
                '}';
    }
}
