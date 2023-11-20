package com.org.persistence.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Metadata")
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MetadataID")
    private Long metadataId;

    @Column(name = "ParentResourceID")
    private String parentResourceId;

}
