package com.saig.drex.controller;

import com.saig.drex.model.NYTimesConfig;
import com.saig.drex.service.ConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/nytimes")
@RequiredArgsConstructor
public class ConfigController {

    private final ConfigService configService;

    @RequestMapping("/config/{appId}")
    public Mono<NYTimesConfig> getNYTimesConfigByAppId(@PathVariable("appId") String appId) {
        return configService.getNYTimesConfigByAppId(appId);
    }

    @GetMapping("/config/app/{appName}")
    public Mono<NYTimesConfig> getNYTimesConfigByAppName(@PathVariable("appName") String appName) {
        return configService.getNYTimesConfigByAppName(appName);
    }

    @GetMapping("/config/all")
    public Flux<NYTimesConfig> getAllNYTimesConfigs() {
        return configService.getAllNYTimesConfigs();
    }

    @PostMapping("/config/add")
    public Mono<NYTimesConfig> saveNYTimesConfig(@RequestBody NYTimesConfig nyTimesConfig) {
        return configService.saveNYTimesConfig(nyTimesConfig);
    }

    @PutMapping("/config/update")
    public Mono<NYTimesConfig> updateNYTimesConfig(@RequestBody NYTimesConfig nyTimesConfig) {
        return configService.saveNYTimesConfig(nyTimesConfig);
    }

    @DeleteMapping("/config/{appId}")
    public Mono<Void> deleteNYTimesConfigByAppId(@PathVariable("appId") String appId) {
        return configService.deleteNYTimesConfigByAppId(appId);
    }

    @DeleteMapping("/config/app/{appName}")
    public Mono<Void> deleteNYTimesConfigByAppName(@PathVariable("appName") String appName) {
        return configService.deleteNYTimesConfigByAppName(appName);
    }

    @DeleteMapping("/config/delete/all")
    public Mono<Void> deleteAllNYTimesConfigs() {
        return configService.deleteAllNYTimesConfigs();
    }

}

