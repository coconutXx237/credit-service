package com.klimkin.msconveyor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:rate.properties")
@SpringBootApplication
public class ConveyorApp {

    public static void main(String[] args) {
        SpringApplication.run(ConveyorApp.class, args);
    }

}
