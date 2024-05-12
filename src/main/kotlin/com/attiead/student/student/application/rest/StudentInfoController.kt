package com.attiead.student.student.application.rest

import com.attiead.student.common.response.ResponseDTO
import com.attiead.student.domain.table.Student
import com.attiead.student.student.application.service.StudentApplicationService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/students")
class StudentInfoController(private val studentApplicationService: StudentApplicationService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{sid}")
    fun getStudentInfo(
        @Valid @PathVariable sid: String
    ): ResponseDTO<Student> {
        val studentInfo = studentApplicationService.getStudentInfo(sid)
        return ResponseDTO.success(data = studentInfo)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun getAllStudents(
        @PageableDefault(size = 10) pageable: Pageable
    ): ResponseDTO<Page<Student>> {
        val students = studentApplicationService.getAllStudents(pageable)
        return ResponseDTO.success(data = students)
    }
}
