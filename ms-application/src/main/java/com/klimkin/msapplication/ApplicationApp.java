package com.klimkin.msapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApplicationApp {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationApp.class, args);
    }

}
