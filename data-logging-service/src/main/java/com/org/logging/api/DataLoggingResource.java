package com.org.logging.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.org.kafka.clients.KafkaProducer;
import com.org.kafka.models.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DataLoggingResource {
    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping("/logs")
    public void AddLog(@RequestBody Log log) throws JsonProcessingException {
        kafkaProducer.publishLoggingData(log);
    }
}