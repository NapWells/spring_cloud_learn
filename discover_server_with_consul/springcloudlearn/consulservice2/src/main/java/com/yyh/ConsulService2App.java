package com.yyh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulService2App implements CommandLineRunner {
    @Value("${jdbc.username}")
    private String username;


    @Value("${jdbc.password}")
    private String password;

    public static void main(String[] args){
        SpringApplication.run(ConsulService2App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
    }
}
