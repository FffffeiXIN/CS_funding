package com.sustech.cs_funding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CsFundingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsFundingApplication.class, args);
    }

}
