package com.example.wishsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.wishsystem.mapper")
public class WishSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(WishSystemApplication.class, args);
    }
}
