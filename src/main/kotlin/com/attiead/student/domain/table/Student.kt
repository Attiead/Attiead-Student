package com.attiead.student.domain.table

import com.attiead.student.common.entity.BaseEntity
import com.attiead.student.domain.vo.MentoringTopic
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "students")
class Student(
    @Column(name = "sid")
    val sid: String = UUID.randomUUID().toString(),

    @Column(name = "uid")
    val uid: String,

    @Column(name = "school_email")
    val schoolEmail: String,

    @Enumerated(EnumType.STRING)
    val mentoringTopic: MentoringTopic = MentoringTopic.NONE,

    @Column(name = "requested_subject_name")
    val requestSubjectName: String,

    @Column(name = "professor_name")
    val professorName: String,

    @Column(name = "assignment_deadline")
    val assignmentDeadline: LocalDateTime

) : BaseEntity()
