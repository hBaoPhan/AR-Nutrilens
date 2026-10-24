package com.nutrilens.api;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class NutriLensApplication {

    @PostConstruct
    public void init() {
        // Enforce Vietnam timezone (UTC+7) across JVM and Jackson date formatting
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
    }

    public static void main(String[] args) {
        SpringApplication.run(NutriLensApplication.class, args);
    }
}
