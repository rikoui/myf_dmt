package com.bjdreamtech.dmt.util;

import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 * @author duanwu
 */
public class DMTPageUtil {

	/**
	 * 设置默认每页记录数（根据项目情况自行更改）
	 */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 每页记录数
     */
    private int pageSize;
    
    /**
     * 当前页数
     */
    private int currentPage;
    
    /**
     * 上一页
     */
    private int prePage;
    
    /**
     * 下一页
     */
    private int nextPage;
    
    /**
     * 总页数
     */
    private int totalPage;
    
    /**
     * 总条数
     */
    private int totalCount;
    
    /**
     * 数据集
     */
    private List<Map<String,Object>> dataList;

    /**
     * 页码
     */
    private int[] nums;

    /**
     * 构造方法，默认当前第一页，设置每页默认记录数
     */
    public DMTPageUtil() {
        this.currentPage = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    /**
     * 自行设置当前页数和每页记录数
     * @param currentPage
     * @param pageSize
     */
    public DMTPageUtil(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
    
    /**
     * 设置上一页和下一页
     */
    public void setPreAndNextPage(){
    	this.prePage = currentPage==1 ? 1 : this.currentPage-1;
    	this.nextPage = currentPage==this.totalPage ? this.currentPage : this.currentPage+1;
    }

    /**
     * 获取当前页数
     * @return
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 设置当前页数
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 获取每页记录数
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页记录数
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取上一页
     * @return
     */
    public int getPrePage() {
        return prePage;
    }

    /**
     * 设置上一页
     * @param prePage
     */
    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    /**
     * 获取下一页
     * @return
     */
    public int getNextPage() {
        return nextPage;
    }

    /**
     * 设置下一页
     * @param nextPage
     */
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * 设置总页数
     * @param totalPage
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 获取总条数
     * @return
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总条数
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取数据集
     * @return
     */
	public List<Map<String, Object>> getDataList() {
		return dataList;
	}

	/**
	 * 设置数据集
	 * @param dataList
	 */
	public void setDataList(List<Map<String, Object>> dataList) {
		this.dataList = dataList;
	}

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }
}
