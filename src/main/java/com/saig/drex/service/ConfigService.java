package com.saig.drex.service;

import com.saig.drex.model.NYTimesConfig;
import com.saig.drex.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ConfigService {

    private static final String UTC = "UTC";

    @Value("${app-config.base-url}")
    private final String baseUrl;
    @Value("${app-config.api-secret}")
    private final String apiSecret;
    private final ConfigRepository configRepository;

    public ConfigService(ConfigRepository configRepository,
                         @Value("${app-config.base-url}") String baseUrl,
                         @Value("${app-config.api-secret}") String apiSecret) {
        this.configRepository = configRepository;
        this.baseUrl = baseUrl;
        this.apiSecret = apiSecret;
    }

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
        return configRepository.save(buildNYTimesConfig(nyTimesConfig, false));
    }

    public Mono<NYTimesConfig> updateNYTimesConfig(NYTimesConfig nyTimesConfig) {
        return configRepository.save(buildNYTimesConfig(nyTimesConfig, true));
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

    private NYTimesConfig buildNYTimesConfig(NYTimesConfig nyTimesConfig, boolean isUpdate) {
        nyTimesConfig.setApiSecret(apiSecret);
        nyTimesConfig.setStatus(isUpdate ? nyTimesConfig.getStatus() : "Active");
        nyTimesConfig.setBaseUrl(baseUrl);
        nyTimesConfig.setUpdated(toTimesStamp());

        if (!isUpdate) {
            nyTimesConfig.setCreated(toTimesStamp());
        }
        return nyTimesConfig;
    }

    private LocalDateTime toTimesStamp() {
        return LocalDateTime.now(ZoneId.of(UTC));
    }

}
