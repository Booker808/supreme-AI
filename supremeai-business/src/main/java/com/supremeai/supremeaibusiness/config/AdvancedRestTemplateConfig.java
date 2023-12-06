package com.supremeai.supremeaibusiness.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AdvancedRestTemplateConfig {

    @Value("${supremeai.resttemplate.connect-timeout}")
    private int connectTimeout;

    @Value("${supremeai.resttemplate.read-timeout}")
    private int readTimeout;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(connectTimeout * 60 * 1000) // 设置连接超时时间
                .setReadTimeout(readTimeout * 60 * 1000)    // 设置读取超时时间
                .build();
    }
}
