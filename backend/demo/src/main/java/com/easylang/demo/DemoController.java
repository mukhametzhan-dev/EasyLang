package com.easylang.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from Spring Boot! cheking";
    }
} 