package com.example.demo.service

import com.example.demo.client.ApiClient
import mu.KotlinLogging
import org.springframework.stereotype.Service
import kotlin.system.measureTimeMillis

private val log = KotlinLogging.logger { }

@Service
class ApiService(private val apiClient: ApiClient)
{
    fun getDefault(times:Int) {
        this.call(times) {
            apiClient.get()
        }.also { log.debug { "Called get default" } }
    }

    fun getProxied(times: Int) {
        this.call(times) {
            apiClient.getProxied()
        }.also { log.debug { "Called get vgs proxied" } }
    }

    private fun <T> call(times:Int, block: () -> T) {
        log.debug { "Starting the call with times $times" }
        for (i in 1..times) {
            measureTimeMillis {
                try {
                    block()
                } catch (e: Exception) {
                    log.error { "failed due to ${e.message}" }
                }
            }.also { log.debug { "Call index $i took $it " } }
        }
        log.debug { "Ending the call with times $times" }
    }
}