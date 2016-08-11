package com.example.scm32.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scm32.dao.GoodsMapper;
import com.example.scm32.entity.Goods;
import com.example.scm32.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService{
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@SuppressWarnings("unused")
	@PostConstruct//在构造方法后，初化前执行
	private void initBase(){
		super.baseMapper =  goodsMapper;
		
	}

}
