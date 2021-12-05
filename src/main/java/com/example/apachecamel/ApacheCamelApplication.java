package com.example.apachecamel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
@EnableConfigurationProperties
public class ApacheCamelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApacheCamelApplication.class, args);
    }

}
