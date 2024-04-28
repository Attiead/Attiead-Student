package com.attiead.student.student.application.dto.request

import java.time.LocalDateTime

data class StudentCreateRequestDTO(

    val uid: String,

    val schoolEmail: String,

    val mentoringTopic: String?,

    val requestSubjectName: String,

    val professorName: String,

    val assignmentDeadline: LocalDateTime
)
