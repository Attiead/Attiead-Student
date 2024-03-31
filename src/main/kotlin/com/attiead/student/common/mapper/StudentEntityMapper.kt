package com.attiead.student.common.mapper

import com.attiead.student.domain.table.Student
import com.attiead.student.student.application.dto.request.StudentCreateRequestDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface StudentEntityMapper {

    fun convertToStudentEntity(
        studentCreateRequestDTO: StudentCreateRequestDTO
    ): Student
}
