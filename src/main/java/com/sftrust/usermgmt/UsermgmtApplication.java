package com.sftrust.usermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UsermgmtApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsermgmtApplication.class, args);
    }

}
