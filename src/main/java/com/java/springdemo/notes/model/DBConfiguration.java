package com.java.springdemo.notes.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Data
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDbConnection() {
        String message = "DB Connection for Dev";
        printDetails(message);
        return message;
    }

    @Profile("prod")
    @Bean
    public String prodDbConnection() {
        String message = "DB Connection for Prod";
        printDetails(message);
        return message;
    }

    @Profile("test")
    @Bean
    public String testDbConnection() {
        String message = "DB Connection for Test";
        printDetails(message);
        return message;
    }

    public void printDetails(String message) {
        System.out.println(message);
        System.out.println(driverClassName);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }
}
