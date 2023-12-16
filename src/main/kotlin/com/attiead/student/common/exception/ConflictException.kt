package com.attiead.student.common.exception

import com.attiead.student.common.model.MetaCode

class ConflictException(message: String? = null, data: Any? = null) : BaseHttpException(
    metaCode = MetaCode.CONFLICT,
    message = message,
    data = data
)
