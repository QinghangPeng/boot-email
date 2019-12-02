package com.pqh.basic.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootEmailApplication {

    public static void main(String[] args){
        SpringApplication.run(BootEmailApplication.class, args);
    }

}
