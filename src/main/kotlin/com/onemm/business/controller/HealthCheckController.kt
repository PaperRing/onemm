package com.onemm.business.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthCheckController {

    @GetMapping
    fun healthCheck(): ResponseEntity<Any> {
        println("health check api called")
        return ResponseEntity.ok("")
    }

}
