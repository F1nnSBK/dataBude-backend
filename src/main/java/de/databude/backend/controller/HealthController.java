package de.databude.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface HealthController {

    @GetMapping("/health")
    public String health();

    @GetMapping("/version")
    public String version();

}
