package com.org.kafka.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Log {
    private String level;
    private String message;
    private String resourceId;
    private Timestamp timestamp;
    private String traceId;
    private String spanId;
    private String commit;
    private MetaData metaData;
}
