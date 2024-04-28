package com.attiead.student.domain.service

import com.attiead.student.domain.table.Student
import com.attiead.student.infra.jpa.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val studentRepository: StudentRepository
) {
    fun saveStudent(student: Student) {
        studentRepository.save(student)
    }
}
