package com.attiead.student.domain.table

import com.attiead.student.common.entity.BaseEntity
import com.attiead.student.domain.vo.*
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "students")
class Student(
    @Column(name = "uid")
    val uid: String,

    @Column(name = "sid")
    val sid: String = UUID.randomUUID().toString(),

    @Column(name = "school_email")
    val schoolEmail: String,

    @Enumerated(EnumType.STRING)
    val educationLevel: EducationLevel = EducationLevel.ETC,

    @Enumerated(EnumType.STRING)
    val tutoringSubject: TutoringSubject = TutoringSubject.NONE,

    @Enumerated(EnumType.STRING)
    val currentAcademicLevel: CurrentAcademicLevel = CurrentAcademicLevel.BEGINNER,

    @Enumerated(EnumType.STRING)
    val mentoringTopics: MentoringTopics = MentoringTopics.NONE,

    @Enumerated(EnumType.STRING)
    val classFormat: ClassFormat = ClassFormat.FACE_TO_FACE,

    @Enumerated(EnumType.STRING)
    val preferredTeachingStyles: PreferredTeachingStyles = PreferredTeachingStyles.INSTRUCTOR_LEAD

) : BaseEntity()
