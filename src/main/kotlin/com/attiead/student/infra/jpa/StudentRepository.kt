package com.attiead.student.infra.jpa

import com.attiead.student.common.entity.ID
import com.attiead.student.domain.table.Student
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface StudentRepository :
    JpaRepository<Student, ID> {}
