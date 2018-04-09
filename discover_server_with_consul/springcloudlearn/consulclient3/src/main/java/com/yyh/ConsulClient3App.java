package com.yyh;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Configuration
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ConsulClient3App {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private  RestTemplate restTemplate;

    private static final String  SERVICE_ID = "consulservice3";

    @RequestMapping(value = "/say")
    @HystrixCommand(fallbackMethod = "defaultSay")
    public String sayService() throws InterruptedException {
        return restTemplate.getForObject("http://"+SERVICE_ID+"/say",String.class);
    }

    private String defaultSay(){
        return "service " + SERVICE_ID +" not available";
    }



    public static void main(String[] args){
        SpringApplication.run(ConsulClient3App.class, args);
    }

}
