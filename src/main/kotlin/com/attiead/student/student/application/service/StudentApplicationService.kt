package com.attiead.student.student.application.service

import com.attiead.student.common.mapper.StudentMapper
import com.attiead.student.domain.service.StudentService
import com.attiead.student.domain.table.Student
import com.attiead.student.student.application.dto.request.StudentCreateRequestDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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

    @Transactional(readOnly = true)
    fun getStudentInfo(sid: String): Student {
        return studentService.getStudentById(sid)
    }

    @Transactional
    fun getAllStudents(pageable: Pageable): Page<Student> {
        return studentService.getAllStudents(pageable)
    }
}
