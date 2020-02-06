package com.springcloud.learn.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.learn.api.entity.Member;
import com.springcloud.learn.api.service.IOrderService;
import com.springcloud.learn.feign.MemberServiceFeign;

@RestController
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	MemberServiceFeign feign;
	
	@RequestMapping("/orderToMember")
	public String orderToMember(@RequestParam("name") String name) {
		Member member = feign.getMember(name);
		return member.toString();
	}
	
	@HystrixCommand(fallbackMethod = "hystrixFallback")
	@RequestMapping("/orderToMemberHystrix")
	public String orderToMemberHystrix() {
		System.out.println("orderToMemberHystrix:"+Thread.currentThread().getName());
		return feign.getMember("123").toString();
	}
	
	public String hystrixFallback() {
		return "this is fallback method";
	}
}
