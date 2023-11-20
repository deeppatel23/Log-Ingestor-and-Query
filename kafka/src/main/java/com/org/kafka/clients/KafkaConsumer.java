package com.org.kafka.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.kafka.models.Log;
import com.org.kafka.models.MetaData;
import com.org.persistence.models.Logs;
import com.org.persistence.models.Metadata;
import com.org.persistence.repositories.LogRepository;
import com.org.persistence.repositories.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class KafkaConsumer {

    @Autowired
    LogRepository logRepository;

    @Autowired
    MetadataRepository metadataRepository;

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}")
    public void listen(String logString) throws JsonProcessingException {

        Log log = objectMapper.readValue(logString, Log.class);
        System.out.println(log);

        Logs logs = new Logs();
        Metadata metadata = new Metadata();
        Metadata savedMetadata = new Metadata();

        metadata.setParentResourceId(log.getMetaData().getParentResourceId());

        savedMetadata = metadataRepository.save(metadata);
        logs.setMetadataId(savedMetadata.getMetadataId());

        logs.setLevel(log.getLevel());
        logs.setMessage(log.getMessage());
        logs.setCommit(log.getCommit());
        logs.setTraceId(log.getTraceId());
        logs.setSpanId(log.getSpanId());
        logs.setResourceId(log.getResourceId());
        logs.setTimestamp(log.getTimestamp());
        logRepository.save(logs);
    }
}
