package com.attiead.student.domain.service

import com.attiead.student.common.exception.NotFoundException
import com.attiead.student.domain.table.Student
import com.attiead.student.infra.jpa.StudentRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val studentRepository: StudentRepository
) {
    fun saveStudent(student: Student) {
        studentRepository.save(student)
    }

    fun getStudentById(sid: String): Student {
        return studentRepository.findBySid(sid)
            ?: throw NotFoundException(message = "No student with sid '$sid' exists")
    }

    fun getAllStudents(pageable: Pageable): Page<Student> {
        return studentRepository.findAll(pageable)
    }
}
