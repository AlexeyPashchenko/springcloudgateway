package com.example.hidden.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HiddenController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(path = "/hidden/{id}")
    public String getHiddenString(@PathVariable String id) {
        log.info("method getHiddenString() were called! and id: " + id);
        return "HiddenString is Test! and id: " + id;
    }

    @GetMapping(path = "/hidden")
    public String getHiddenString() {
        log.info("method getHiddenString() were called!");
        return "HiddenString is Test! and " + appName;
    }

    @GetMapping
    public String getRootHiddenString() {
        log.info("method getRootHiddenString() were called!");
        return "RootHiddenString is Test! and " + appName;
    }
}
