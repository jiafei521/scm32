package com.example.scm32.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scm32.dao.SupplierMapper;
import com.example.scm32.entity.Supplier;
import com.example.scm32.service.SupplierService;

@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService  {

	@Autowired
	protected SupplierMapper supplierMapper;
	
	@SuppressWarnings("unused")
	@PostConstruct//在构造方法后，初化前执行
	private void initBase(){
		super.baseMapper = supplierMapper;
	}
//
//	public int insert(Supplier entity) throws Exception {
//		return supplierMapper.insert(entity);
//	}
//
//	public int delete(Supplier entity) throws Exception {
//		return supplierMapper.delete(entity);
//	}
//
//	public int update(Supplier entity) throws Exception {
//		return supplierMapper.update(entity);
//	}
//
//
//	public Page<Supplier> selectPage(Page<Supplier> page) {
//		page.setTotalRecord(supplierMapper.selectPageCount(page));
//		page.setList(supplierMapper.selectPageList(page));
//		return page;
//	}
//
//	public Page<Supplier> selectPageUseDyc(Page<Supplier> page) {
//		page.setTotalRecord(supplierMapper.selectPageCountUseDyc(page));
//		page.setList(supplierMapper.selectPageListUseDyc(page));
//		System.out.println(page);
//		return page;
//	}
//
//	public Supplier select(Supplier entity) {
//		return supplierMapper.select(entity).get(0);
//	}
//
//	public int deleteList(String[] pks) throws Exception {
//		return supplierMapper.deleteList(pks);
//	}
//
//	public List<Supplier> selectList() {
//		return supplierMapper.selectList();
//	}

	
	


	


}
