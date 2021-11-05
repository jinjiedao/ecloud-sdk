package com.agile.ecloud.sdk.common;


/**
 * 分页信息封装
 */

public class Pagination {

    private final static int DEFAULT_PAGE_SZIE = 20;


    private final static int DEFAULT_PAGE = 1;

    // 当前页码
    private int pageCurrent;

    // 每页大小
    private int pageSize;

    public int getPageCurrent() {
		return pageCurrent;
	}


	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public Pagination() {
        this.pageSize = DEFAULT_PAGE_SZIE;
    }


    public static Pagination getInstantce(Integer pageCurrent, Integer pageSize) {
        Pagination pagination = new Pagination();
        pagination.pageCurrent = pageCurrent == null ? DEFAULT_PAGE : pageCurrent;
        pagination.pageSize = pageSize == null ? DEFAULT_PAGE_SZIE : pageSize;
        return pagination;
    }

}
