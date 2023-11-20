package com.org.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.org.persistence.repositories", "com.org.query.api"})
@EnableJpaRepositories(basePackages = "com.org.persistence.repositories")
@EntityScan(basePackages = "com.org.persistence.models")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}