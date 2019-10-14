package com.example.junittest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.junittest.dao")
/*@EnableScheduling*/
public class JunittestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JunittestApplication.class, args);
    }

}
