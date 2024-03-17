package com.attiead.student

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
class AttieadStudentApplication

fun main(args: Array<String>) {
    runApplication<AttieadStudentApplication>(*args)
}
