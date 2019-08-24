package com.jiema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class YimaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YimaApplication.class, args);
    }

}
