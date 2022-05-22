package com.saig.drex.service;

import com.saig.drex.model.NYTimesConfig;
import com.saig.drex.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ConfigService {

    private final ConfigRepository configRepository;

    public Mono<NYTimesConfig> getNYTimesConfigByAppId(String appId) {
        return configRepository.findByAppId(appId);
    }

    public Mono<NYTimesConfig> getNYTimesConfigByAppName(String appName) {
        return configRepository.findByAppName(appName);
    }

    public Flux<NYTimesConfig> getAllNYTimesConfigs() {
        return configRepository.findAll();
    }

    public Mono<NYTimesConfig> saveNYTimesConfig(NYTimesConfig nyTimesConfig) {
        return configRepository.save(nyTimesConfig);
    }

    public Mono<Void> deleteNYTimesConfigByAppId(String appId) {
        return configRepository.deleteByAppId(appId);
    }

    public Mono<Void> deleteNYTimesConfigByAppName(String appName) {
        return configRepository.deleteByAppName(appName);
    }

    public Mono<Void> deleteAllNYTimesConfigs() {
        return configRepository.deleteAll();
    }

}
