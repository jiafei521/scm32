package com.example.scm32.service;

import com.example.scm32.entity.BuyOrder;

public interface BuyOrderService extends BaseService<BuyOrder>{
	
	public int insertBuyOrder(BuyOrder buyOrder);

}
