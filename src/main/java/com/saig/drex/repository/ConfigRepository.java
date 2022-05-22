package com.saig.drex.repository;

import com.saig.drex.model.NYTimesConfig;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface ConfigRepository extends R2dbcRepository<NYTimesConfig, Integer> {

    Mono<NYTimesConfig> findByAppId(String appId);

    Mono<NYTimesConfig> findByAppName(String appName);

    Mono<Void> deleteByAppId(String appId);

    Mono<Void> deleteByAppName(String appName);
    
}
