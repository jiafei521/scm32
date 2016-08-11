package com.example.scm32.dao;

import java.util.List;

import com.example.scm32.entity.BuyOrderDetail;

public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail> {
	public int insertList(List<BuyOrderDetail> buyOrderDetails);
}