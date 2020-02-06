package com.springcloud.learn.api.fallback;

import org.springframework.stereotype.Component;

import com.springcloud.learn.api.entity.Member;
import com.springcloud.learn.feign.MemberServiceFeign;

@Component
public class MemberServiceFallback implements MemberServiceFeign {

	@Override
	public Member getMember(String name) {
		Member member = new Member();
		member.setName("Server is busy...fallback class");
		member.setAge(0);
		return member;
	}

}
