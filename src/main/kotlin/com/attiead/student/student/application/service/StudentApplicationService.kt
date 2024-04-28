package com.attiead.student.student.application.service

import com.attiead.student.common.mapper.StudentMapper
import com.attiead.student.domain.service.StudentService
import com.attiead.student.student.application.dto.request.StudentCreateRequestDTO
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class StudentApplicationService(
    private val studentService: StudentService,
) {

    @Transactional
    fun registerStudentInfo(
        studentCreateRequestDTO: StudentCreateRequestDTO
    ) {
        studentService.saveStudent(
            student = StudentMapper.INSTANCE.convertToStudent(studentCreateRequestDTO)
        )
    }
}
