package com.example.demo.configuration

import com.verygoodsecurity.spring.annotation.EnableVgsProxy
import com.verygoodsecurity.spring.annotation.VgsProxied
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.client.RestTemplate

@Configuration
@EnableVgsProxy
class VgsConfig {
    @Bean
    @VgsProxied
    fun vgsProxies(): RestTemplate = RestTemplate()

    @Bean
    @Primary
    fun restTemplate(): RestTemplate = RestTemplate()
}