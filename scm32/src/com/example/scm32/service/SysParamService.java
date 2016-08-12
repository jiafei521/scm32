package com.example.scm32.service;

import java.util.Map;

import com.example.scm32.entity.SysParam;

public interface SysParamService extends BaseService<SysParam> {
    public Map<String,Object> selectMapList();
	 
}
