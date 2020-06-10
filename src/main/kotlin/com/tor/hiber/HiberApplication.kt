package com.tor.hiber

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class HiberApplication

fun main(args: Array<String>) {
    runApplication<HiberApplication>(*args)
}
