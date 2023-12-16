package com.attiead.student.student.application.rest

import com.attiead.student.common.constant.VERSION
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping("/")
    fun index() = "Attiead-Student $VERSION"
}
