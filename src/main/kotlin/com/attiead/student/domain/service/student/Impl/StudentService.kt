package com.attiead.student.domain.service.student.Impl

import com.attiead.student.domain.service.student.StudentCrudService
import com.attiead.student.domain.table.Student
import com.attiead.student.infra.jpa.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val studentRepository: StudentRepository
): StudentCrudService {
    override fun saveStudent(student: Student) {
        studentRepository.save(student)
    }
}