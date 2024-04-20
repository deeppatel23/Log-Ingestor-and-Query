package com.org.elastic.repositories;

import com.org.elastic.models.LogDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDocumentRepository extends ElasticsearchRepository<LogDocument, Long> {
    // Define custom queries or use default methods provided by ElasticsearchRepository
}

