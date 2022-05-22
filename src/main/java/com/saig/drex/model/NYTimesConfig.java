package com.saig.drex.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Value
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
    Timestamp created;
    Timestamp updated;

}
