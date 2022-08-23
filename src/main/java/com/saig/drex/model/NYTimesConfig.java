package com.saig.drex.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@Table("nytimes_config")
public class NYTimesConfig {

    @Id
    int id;
    String appName;
    String appId;
    String apiKey;
    String apiSecret;
    String status;
    String baseUrl;
    LocalDateTime created;
    LocalDateTime updated;

}
