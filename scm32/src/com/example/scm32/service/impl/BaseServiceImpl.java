package com.example.scm32.service.impl;

import java.util.List;

import com.example.scm32.dao.BaseMapper;
import com.example.scm32.entity.Page;
import com.example.scm32.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	protected BaseMapper<T> baseMapper;
	
	public int insert(T entity) throws Exception {
		  return baseMapper.insert(entity);
	}

	public int update(T entity) throws Exception {
		return baseMapper.update(entity);
	}

	public int delete(T entity) throws Exception {
		return baseMapper.delete(entity);
	}

	public int deleteList(String[] pks) throws Exception {
		return baseMapper.deleteList(pks);
	}

	public T select(T entity) {
		return baseMapper.select(entity).get(0);
	}

	public List<T> selectList() {
		return baseMapper.selectList();
	}

	public Page<T> selectPage(Page<T> page) {
		page.setTotalRecord(baseMapper.selectPageCount(page));
		page.setList(baseMapper.selectPageList(page));
		return page;
	}

	public Page<T> selectPageUseDyc(Page<T> page) {
		page.setTotalRecord(baseMapper.selectPageCountUseDyc(page));
		page.setList(baseMapper.selectPageListUseDyc(page));
		return page;
	}

}
