package com.example.demo.client

import com.verygoodsecurity.spring.annotation.VgsProxied
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

private const val GOOGLE_URL = "https://www.google.com"

@Component
class ApiClient(
    private val restTemplate: RestTemplate,
    @VgsProxied
    private val vgsProxied: RestTemplate
) {
    fun get() = restTemplate.getForObject(GOOGLE_URL, String::class.java)
    fun getProxied() = vgsProxied.getForObject(GOOGLE_URL, String::class.java)
}