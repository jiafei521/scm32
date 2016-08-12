package com.example.scm32.dao;

import java.util.List;

import com.example.scm32.entity.SysParam;

public interface SysParamMapper extends BaseMapper<SysParam> {
	public List<SysParam> selectList(String type);
	public List<SysParam> selectOthreTable(String sql);
   
}