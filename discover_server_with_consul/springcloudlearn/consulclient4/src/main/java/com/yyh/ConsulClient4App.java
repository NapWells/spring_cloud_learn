package com.yyh;

import com.yyh.service.SayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//必不可少
@RestController
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ConsulClient4App {

    @Autowired
    private SayService sayService;

    @RequestMapping("say")
    public String say() throws InterruptedException {
        return sayService.say();
    }

    public static void main(String[] args){
        SpringApplication.run(ConsulClient4App.class, args);
    }
}
