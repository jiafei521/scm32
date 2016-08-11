package com.example.scm32.dao;

import java.util.List;

import com.example.scm32.entity.Page;

public interface BaseMapper<T> {
	
		//添加单个对象
		public int insert(T entity);
		
		//修改单个对象
		public int update(T entity);
		
		//删除单个对象 
		public int delete(T entity);
		
		//通过主键（数组）批量删除数据
		public int deleteList(String [] pks) throws Exception;
		
		
		//查询单个对象
		public List<T> select(T entity);
		
		//查询所有
		public List<T> selectList();
		
		//通过关键字分页查询数据列表
		public List<T> selectPageList(Page<T> page);
		
		//通过关键字分页查询，返回总记录数
		public Integer selectPageCount(Page<T> page);
		
		//通过关键字分页查询数据列表
		public List<T> selectPageListUseDyc(Page<T> page);
			
			//通过关键字分页查询，返回总记录数
		public Integer selectPageCountUseDyc(Page<T> page);

}
