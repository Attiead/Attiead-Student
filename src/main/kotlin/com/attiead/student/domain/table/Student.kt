package com.attiead.student.domain.table

import com.attiead.student.common.entity.BaseEntity
import com.attiead.student.domain.vo.EducationLevel
import com.attiead.student.domain.vo.TutoringSubject
import com.attiead.student.domain.vo.ClassFormat
import com.attiead.student.domain.vo.PreferredTeachingStyles
import com.attiead.student.domain.vo.CurrentAcademicLevel
import com.attiead.student.domain.vo.MentoringTopics
import jakarta.persistence.Table
import jakarta.persistence.Entity
import jakarta.persistence.Column
import jakarta.persistence.Enumerated
import jakarta.persistence.EnumType
import java.util.UUID

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
