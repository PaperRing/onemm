package com.onemm.common.config

import kong.unirest.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HttpClientConfig {

    @Bean
    fun http(): UnirestInstance {
        val unirest = Unirest.spawnInstance()

        unirest.config()
            .interceptor(object : Interceptor {
                override fun onRequest(request: HttpRequest<*>?, config: Config?) {
                    if (request == null) return
                    request.header("Accept", "*/*")
                        .header("Content-Type", "application/json")
                }
            })
            .concurrency(8192, 512)
            .addShutdownHook(true)
            .socketTimeout(180000)

        return unirest
    }

}
