package com.org.persistence.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Logs")
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogID")
    private Long logId;

    @Column(name = "Level")
    private String level;

    @Column(name = "Message")
    private String message;

    @Column(name = "ResourceID")
    private String resourceId;

    @Column(name = "Timestamp")
    private Date timestamp;

    @Column(name = "TraceID")
    private String traceId;

    @Column(name = "SpanID")
    private String spanId;

    @Column(name = "Commit")
    private String commit;

    @Column(name = "MetadataID")
    private Long metadataId;

}
