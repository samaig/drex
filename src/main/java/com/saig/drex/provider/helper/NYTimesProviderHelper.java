package com.saig.drex.provider.helper;

import com.saig.drex.model.NYTimesConfig;
import com.saig.drex.service.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Service
public class NYTimesProviderHelper {

    private final String appName;
    private final ConfigService configService;

    public NYTimesProviderHelper(
            @Value("${spring.application.name}") String appName,
            ConfigService configService) {
        this.appName = appName;
        this.configService = configService;
    }

    public WebClient setWebClientBuilder(
            WebClient.Builder webClientBuilder,
            HttpClient httpClient,
            String nytimesBaseUrl) {

        return webClientBuilder
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(nytimesBaseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<String> getApiKey() {
        return getConfigByAppName(appName)
                .map(NYTimesConfig::getApiKey)
                .switchIfEmpty(Mono.error(new RuntimeException("ApiKey is null or empty")));
    }

    private Mono<NYTimesConfig> getConfigByAppName(String appName) {
        return configService.getNYTimesConfigByAppName(appName)
                .switchIfEmpty(Mono.error(new RuntimeException("NYTimes config not found")));
    }
}
