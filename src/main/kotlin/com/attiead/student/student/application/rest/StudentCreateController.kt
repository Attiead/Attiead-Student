package com.attiead.student.student.application.rest

import com.attiead.student.common.response.ResponseDTO
import com.attiead.student.student.application.dto.request.StudentCreateRequestDTO
import com.attiead.student.student.application.service.StudentApplicationService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/students")
class StudentCreateController(private val studentApplicationService: StudentApplicationService) {

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    fun createStudentInfo(
        @Valid @RequestBody
        studentCreateRequestDTO: StudentCreateRequestDTO
    ): ResponseDTO<Unit> {
        studentApplicationService.registerStudentInfo(studentCreateRequestDTO)
        return ResponseDTO.success()
    }
}
