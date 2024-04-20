package com.org.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@ComponentScan(basePackages = {"com.org.kafka", "com.org.logging", "org.com.elastic"})
@EnableJpaRepositories(basePackages = "com.org.persistence.repositories")
@EnableElasticsearchRepositories(basePackages = "com.org.elastic.repositories")
@EntityScan("com.org.persistence.models")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
