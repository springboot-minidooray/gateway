package com.nhnacademy.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.nhnacademy.address")
@Data
public class ApiProperties {
    private String accountApi;
    private String taskApi;
}
