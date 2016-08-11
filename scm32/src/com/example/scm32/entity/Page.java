package com.example.scm32.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2465173883177680215L;

	private Integer page;//当前页 前台
	
	private Integer totalPage;//总页数 前台计算
	
	private Integer totalRecord;//总记录数 数据库查询
	
	private Integer rows;//页大小 前台
	
	private List<T> list;//记录数 数据库
	
	private Integer start;//开始记录数
	
	private T paramEntity;//用于多条件查询
	
	private Map<String,Object> map = new HashMap<String, Object>();
	
	
	public Map<String, Object> getMap() {
		return map;
	}

//	public void setMap(Map<String, Object> map) {
//		this.map = map;
//	}

	public Integer getStart() {
		setStart((page-1)*rows);
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}


	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

//	public Integer getTotalRecord() {
//		return totalRecord;
//	}

	public void setTotalRecord(Integer totalRecord) {
		map.put("total", totalRecord);
		this.totalRecord = totalRecord;
	}


	

	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

//	public List<T> getList() {
//		return list;
//	}

	public void setList(List<T> list) {
		map.put("rows", list);
		this.list = list;
	}

	public T getParamEntity() {
		return paramEntity;
	}

	public void setParamEntity(T paramEntity) {
		this.paramEntity = paramEntity;
	}

	@Override
	public String toString() {
		return "PageMe [page=" + page + ", totalPage=" + totalPage
				+ ", totalRecord=" + totalRecord + ", rows=" + rows + ", list="
				+ list + ", start=" + start + ", paramEntity=" + paramEntity
				+ "]";
	}

	


	
	
}
