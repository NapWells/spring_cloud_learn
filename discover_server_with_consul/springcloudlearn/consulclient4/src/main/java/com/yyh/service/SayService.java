package com.yyh.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "consulservice3",fallback = FallbackSayService.class)
public interface SayService {

    @RequestMapping(value = "say")
    String say();
}
