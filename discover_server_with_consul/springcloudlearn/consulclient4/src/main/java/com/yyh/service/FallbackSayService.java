package com.yyh.service;

import org.springframework.stereotype.Component;

@Component
public class FallbackSayService implements SayService{
    @Override
    public String say() {
        return "service not available";
    }
}
