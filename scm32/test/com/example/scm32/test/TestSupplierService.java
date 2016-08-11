package com.example.scm32.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.scm32.entity.Page;
import com.example.scm32.entity.Supplier;
import com.example.scm32.service.SupplierService;

public class TestSupplierService {
	private ApplicationContext ac;
	private SupplierService supplierService ;
	
	@Before
	public void loadAc(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		supplierService = (SupplierService) ac.getBean("supplierService");
	}
	
	@Test
	public void  testSelectPageList() throws Exception{
		Page<Supplier> page = new Page<Supplier>();
		//page.setKeyWord("%供应商%");
		Supplier supplier = new Supplier();
		supplier.setSupName("%供应商%");
		supplier.setSupAddress("%%");
		page.setParamEntity(supplier);
		page.setRows(2);
		page.setStart(0);
		page.setPage(1);
		System.out.println(page);
		Page<Supplier> resPage = supplierService.selectPageUseDyc(page);
		//System.out.println(resPage.getList().size());
		System.out.println(resPage);
	}
	@Test
	public void testInsert() throws Exception{
		Supplier supplier = new Supplier();
		supplier.setSupId(7);
		supplier.setSupName("aa");
		int i = supplierService.insert(supplier);
		System.out.println(i);
	}
	@Test
	public void testDeleteList()throws Exception{
		int i = supplierService.deleteList(new String[]{"3","4"});
		//返回受影响的行数
		System.out.println("i-------------------"+i);
	}
	@Test
	public void testUpdate()throws Exception{
		Supplier s = new Supplier();
		s.setSupId(11);
		s = supplierService.select(s);
		s.setSupName("华为供应商");
		System.out.println(s);
		supplierService.update(s);
	}
	@Test
	public void testSelectList(){
		List<Supplier> list = supplierService.selectList();
		System.out.println(list);
	}

}
