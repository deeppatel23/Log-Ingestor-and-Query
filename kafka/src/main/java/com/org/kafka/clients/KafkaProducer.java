package com.org.kafka.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.kafka.config.KafkaConfig;
import com.org.kafka.models.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;
    private final KafkaConfig kafkaConfig;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, KafkaConfig kafkaConfig){
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfig = kafkaConfig;
    }

    public void publishLoggingData(Log log) throws JsonProcessingException {
        kafkaTemplate.send(kafkaConfig.getTopic(), objectMapper.writeValueAsString(log));
    }
}