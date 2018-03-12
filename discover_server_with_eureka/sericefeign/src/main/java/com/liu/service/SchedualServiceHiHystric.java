package com.liu.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String saiHiFromClientOne(String name) {
        return  "sorry "+name;
    }
}
