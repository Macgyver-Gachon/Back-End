package com.project2022.macgyver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableSwagger2
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
