package com.attiead.student.student.application.dto.request

import com.attiead.student.domain.table.Student
import com.attiead.student.domain.vo.MentoringTopic
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class StudentCreateRequestDTO(

    val sid: String,

    @field:NotNull
    val uid: String,

    val schoolEmail: String,

    val mentoringTopic: String,

    val requestSubjectName: String,

    val professorName: String,

    val assignmentDeadline: LocalDateTime

) {
    fun toEntity(): Student {
        return Student(
            uid = uid,
            schoolEmail = schoolEmail,
            mentoringTopic = MentoringTopic.valueOf(
                mentoringTopic.uppercase()
            ),
            requestSubjectName = requestSubjectName,
            professorName = professorName,
            assignmentDeadline = assignmentDeadline
        )
    }
}
