package com.java.springdemo.notes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestConfigurationFiles {
    private String name;
    private String email;
}
