package com.one.pojian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.one.pojian.mapper")
public class PojianApplication {
    public static void main(String[] args) {
        SpringApplication.run(PojianApplication.class, args);
    }
}
