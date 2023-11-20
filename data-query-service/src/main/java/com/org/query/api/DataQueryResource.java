package com.org.query.api;

import com.org.persistence.models.Logs;
import com.org.persistence.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.org.persistence.repositories")
public class DataQueryResource {

    @Autowired
    LogRepository logRepository;


    @GetMapping("/query")
    public List<Logs> findByParams(@RequestParam(required = false) String level,
                                   @RequestParam(required = false) String message,
                                   @RequestParam(required = false) String resourceId,
                                   @RequestParam(required = false) String traceId,
                                   @RequestParam(required = false) String spanId,
                                   @RequestParam(required = false) String commit) {


        return  logRepository.findByCustomParams(
                resourceId, level, traceId, spanId, commit, message);
    }
}
