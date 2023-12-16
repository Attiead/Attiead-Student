package com.attiead.student.common.response

import com.attiead.student.common.model.MetaCode

data class Meta(
    val code: MetaCode,
    val type: String? = code.name,
    val message: String? = null,
)
