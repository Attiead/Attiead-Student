package com.attiead.student.student.application.service

import com.attiead.student.domain.service.student.StudentCrudService
import com.attiead.student.student.application.dto.request.StudentCreateRequestDTO
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class StudentApplicationService(
    private val studentCrudService: StudentCrudService
) {

    @Transactional
    fun createStudent(
        studentCreateRequestDTO: StudentCreateRequestDTO
    ) {
        studentCrudService.saveStudent(
            studentCreateRequestDTO.toEntity()
        )
    }
}
