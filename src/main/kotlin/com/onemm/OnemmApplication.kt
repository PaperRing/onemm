package com.onemm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OnemmApplication

fun main(args: Array<String>) {
    runApplication<OnemmApplication>(*args)
}
