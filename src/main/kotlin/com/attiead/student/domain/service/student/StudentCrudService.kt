package com.attiead.student.domain.service.student

import com.attiead.student.domain.table.Student

interface StudentCrudService {

    fun saveStudent(
        student: Student
    )
}