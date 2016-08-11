package com.example.scm32.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scm32.dao.DeptDao;
import com.example.scm32.entity.Dept;
import com.example.scm32.service.DeptService;

@Service("DeptService")
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDao deptDao;

	public int insertDept(Dept dept) throws Exception {
		int insertDept = deptDao.insertDept(dept);
		//int i = 1/0;
		return insertDept;
	}

	public Dept selectDept(Integer deptId) throws Exception {
		return deptDao.selectDept(deptId);
	}

}
