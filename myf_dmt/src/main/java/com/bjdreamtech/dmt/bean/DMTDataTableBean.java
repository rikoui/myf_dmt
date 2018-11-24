package com.bjdreamtech.dmt.bean;

import java.util.List;

/**
 * 调用DMTDatatable方法返回的数据bean
 * @author duanwu
 *
 */
public class DMTDataTableBean<T> {
	//数据的总条数
	private int total;
	//返回的数据集合
	private List<T> rows;
	
	public DMTDataTableBean(){}
	
	public DMTDataTableBean(int total,List<T> rows){
		this.total = total;
		this.rows = rows;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
}
