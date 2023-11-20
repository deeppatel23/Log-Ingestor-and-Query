package com.org.persistence.repositories;

import com.org.persistence.models.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MetadataRepository extends JpaRepository<Metadata, Integer> {
    Metadata save(Metadata metadata);

    Metadata findByParentResourceId(String parentResourceID);
}