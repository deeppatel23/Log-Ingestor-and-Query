package com.org.persistence.repositories;

import com.org.persistence.models.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Logs, Integer> {

    Logs save(Logs logs);

    @Query("SELECT l FROM Logs l WHERE " +
            "(:resourceId IS NULL OR l.resourceId = :resourceId) AND " +
            "(:level IS NULL OR l.level = :level) AND " +
            "(:traceId IS NULL OR l.traceId = :traceId) AND " +
            "(:spanId IS NULL OR l.spanId = :spanId) AND " +
            "(:commit IS NULL OR l.commit = :commit) AND " +
            "(:message IS NULL OR l.message LIKE '%' || :message || '%')")
    List<Logs> findByCustomParams(
            @Param("resourceId") String resourceId,
            @Param("level") String level,
            @Param("traceId") String traceId,
            @Param("spanId") String spanId,
            @Param("commit") String commit,
            @Param("message") String message);
}
