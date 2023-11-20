package com.org.query.api;

import com.org.persistence.models.Logs;
import com.org.persistence.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.org.persistence.repositories")
public class DataQueryResource {

    @Autowired
    LogRepository logRepository;



    @GetMapping("/query")
    public ResponseEntity<List<Logs>> findByParams(@RequestParam(required = false) String level,
                                   @RequestParam(required = false) String message,
                                   @RequestParam(required = false) String resourceId,
                                   @RequestParam(required = false) String traceId,
                                   @RequestParam(required = false) String spanId,
                                   @RequestParam(required = false) String commit,
                                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String fromTime,
                                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String endTime) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            Timestamp fromTimeVal = (fromTime != null)
                    ? Timestamp.valueOf(LocalDateTime.parse(fromTime, formatter))
                    : null;

            Timestamp endTimeVal = (endTime != null)
                    ? Timestamp.valueOf(LocalDateTime.parse(endTime, formatter))
                    : null;

            List<Logs> logs = logRepository.findByCustomParams(
                    resourceId, level, traceId, spanId, commit, message, fromTimeVal, endTimeVal);

            return ResponseEntity.ok(logs);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }


}
