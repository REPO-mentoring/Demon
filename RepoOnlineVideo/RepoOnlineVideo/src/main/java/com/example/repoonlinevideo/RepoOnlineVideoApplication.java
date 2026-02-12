package com.example.repoonlinevideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RepoOnlineVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepoOnlineVideoApplication.class, args);
    }

}
