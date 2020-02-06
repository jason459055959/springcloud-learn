package com.springcloud.learn.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springcloud.learn.api.entity.Member;

public interface IMemberService {
	
	@RequestMapping("/getMember")
	public Member getMember(@RequestParam("name") String name);
	
	
}
