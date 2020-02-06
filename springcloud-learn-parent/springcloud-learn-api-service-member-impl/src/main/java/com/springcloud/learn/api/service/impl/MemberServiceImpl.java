package com.springcloud.learn.api.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.learn.api.entity.Member;
import com.springcloud.learn.api.service.IMemberService;

@RestController
public class MemberServiceImpl implements IMemberService {
	@Value("${server.port}")
	private Integer port;
	
	@Value("${env}")
	private String env;
	
	@RequestMapping("/getMember")	
	public Member getMember(String name) {
		Member member = new Member();
		member.setName(name+" "+env);
		member.setAge(port);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Member service finished");
		return member;
	}

}
