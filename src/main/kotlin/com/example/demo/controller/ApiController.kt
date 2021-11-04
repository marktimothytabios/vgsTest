package com.example.demo.controller

import com.example.demo.service.ApiService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

private val log = KotlinLogging.logger { }
@RestController
@RequestMapping("/api")
class ApiController(private val apiService: ApiService) {
    @GetMapping
    fun get(@RequestParam times:Int, @RequestParam proxied: Boolean = false) {
        if (proxied) apiService.getProxied(times) else apiService.getDefault(times)
    }
    @GetMapping("ping")
    fun test(): String {
        log.debug { "Test" }
        return "hello"
    }
}