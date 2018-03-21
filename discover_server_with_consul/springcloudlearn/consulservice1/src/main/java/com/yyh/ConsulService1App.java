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
public class ConsulService1App {

    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private int port;

    @RequestMapping(value = "/hi")
    public String hi(){

        return "hello world ! I'm :" + name + ":" + port;
    }
    public static void main(String[] args){
        SpringApplication.run(ConsulService1App.class, args);
    }
}
