package com.java.springdemo.notes.controller;

import com.java.springdemo.notes.exception.ItemNotFoundException;
import com.java.springdemo.notes.exception.SecondException;
import com.java.springdemo.notes.exception.ThirdException;
import com.java.springdemo.notes.model.Error;
import com.java.springdemo.notes.model.TestConfigurationFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestConfigurationFiles testConfigurationFiles;

    @Value("${spring.application.name}")
    private String testName;

    @Value("${server.port}")
    private String testPort;

    @GetMapping("/test")
    public String getApplicationName() {
        return testName;
    }

    @GetMapping("/testport")
    public String getTestPort() {
        return testPort;
    }

    @GetMapping("/testconfigname")
    public String getTestName() {
        return testConfigurationFiles.getName();
    }

    @GetMapping("/testconfigemail")
    public String getTestEmail() {
        return testConfigurationFiles.getEmail();
    }

    @GetMapping("/test/global/exception")
    public void getTestException() {
        throw new ItemNotFoundException();
    }

    @GetMapping("/test/local/exception")
    public void getErrorException() {
        throw new SecondException("TestErrorException");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SecondException.class)
    public Error handleSecondException(final SecondException secondException) {
        return new Error(secondException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ThirdException.class)
    public Error handleThirdException(final ThirdException thirdException) {
        return new Error(thirdException.getMessage());
    }
}

