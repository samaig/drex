package com.saig.drex.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class HttpWebClientConfig {

    @Value("${http.web.client.timeout.connect:5000}")
    private int connectTimeout;
    @Value("${http.web.client.timeout.read:5000}")
    private int readTimeout;
    @Value("${http.web.client.timeout.write:5000}")
    private int writeTimeout;
    @Value("${http.web.client.timeout.response:5000}")
    private int responseTimeout;

    @Bean
    public HttpClient httpClient() {
        return HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeout)
                .responseTimeout(Duration.ofMillis(responseTimeout))
                .doOnConnected(connection -> connection
                        .addHandlerLast(new ReadTimeoutHandler(readTimeout, TimeUnit.MILLISECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(writeTimeout, TimeUnit.MILLISECONDS)));
    }
}
