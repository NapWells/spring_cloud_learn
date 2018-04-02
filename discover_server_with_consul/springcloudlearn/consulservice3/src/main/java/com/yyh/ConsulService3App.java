package com.yyh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulService3App {

    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${server.port}")
    private int servicePort;

    @RequestMapping("/say")
    public String say(){
        return "hello world! I'm '" + serviceName + ":" + servicePort + "'";
    }

    public static void main(String[] args){
        SpringApplication.run(ConsulService3App.class, args);
    }

}
