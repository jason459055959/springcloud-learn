package com.springcloud.learn.api.service;

import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderService {
	
	@RequestMapping("/getOrder")
	public String orderToMember(String name);
}
