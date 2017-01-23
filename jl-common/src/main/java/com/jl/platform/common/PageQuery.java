/**
 * guanyuhuhu 2016年6月18日
 */
package com.jl.platform.common;

/**
 * @author zhanglu
 */
public class PageQuery {
    private static final int MAX_PAGE = 100;
    private static final int MAX_PAGE_SIZE = 100;
    private static final int DEFAULT_PAGE_SIZE = 10;
    private int pageSize = DEFAULT_PAGE_SIZE;
    private int page;
    private String sortFiled = "_id";
    private boolean desc = true;

    public int getPageSize() {
        return Math.min(Math.max(0, pageSize), MAX_PAGE_SIZE);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return Math.min(Math.max(0, page), MAX_PAGE);
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getOffset() {
        return getPage() <= 1 ? 0 : (getPage() - 1) * getPageSize();
    }

    public String getSortFiled() {
        return sortFiled;
    }

    public void setSortFiled(String sortFiled) {
        this.sortFiled = sortFiled;
    }

    public boolean isDesc() {
        return desc;
    }

    public void setDesc(boolean desc) {
        this.desc = desc;
    }
}
