package com.attiead.student.infra.jpa

import com.attiead.student.common.entity.ID
import com.attiead.student.domain.table.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, ID> {

    fun findBySid(sid: String): Student?

}
