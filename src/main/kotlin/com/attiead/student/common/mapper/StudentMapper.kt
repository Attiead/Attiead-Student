package com.attiead.student.common.mapper

import com.attiead.student.domain.table.Student
import com.attiead.student.student.application.dto.request.StudentCreateRequestDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
interface StudentMapper {

    companion object {
        val INSTANCE: StudentMapper = Mappers.getMapper(StudentMapper::class.java)
    }

    @Mappings(
        Mapping(target = "sid", expression = "java(UUID.randomUUID().toString())"),
        Mapping(target = "mentoringTopic", expression = "java(com.attiead.student.domain.vo.MentoringTopic.NONE)")
    )
    fun convertToStudent(
        studentCreateRequestDTO: StudentCreateRequestDTO
    ): Student
}
