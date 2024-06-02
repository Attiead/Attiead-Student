package com.attiead.student.student.application.dto.response

import java.time.LocalDateTime

data class StudentInfoResponseDTO(

    val sid: String,

    val schoolEmail: String,

    val mentoringTopic: String?,

    val requestSubjectName: String,

    val professorName: String,

    val assignmentDeadline: LocalDateTime
)
