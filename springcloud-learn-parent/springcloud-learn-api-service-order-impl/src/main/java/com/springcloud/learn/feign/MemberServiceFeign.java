package com.springcloud.learn.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.springcloud.learn.api.fallback.MemberServiceFallback;
import com.springcloud.learn.api.service.IMemberService;

@FeignClient(name="springcloud-learn-api-service-member", fallback=MemberServiceFallback.class)
public interface MemberServiceFeign extends IMemberService {

}
