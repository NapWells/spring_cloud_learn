package com.yyh.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("consulservice3")
public interface SayService {

    @RequestMapping(value = "say")
    String say();
}
