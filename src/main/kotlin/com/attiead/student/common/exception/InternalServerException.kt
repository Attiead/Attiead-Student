package com.attiead.student.common.exception

import com.attiead.student.common.model.MetaCode

class InternalServerException(message: String? = null, data: Any? = null) : BaseHttpException(
    metaCode = MetaCode.INTERNAL_SERVER_ERROR,
    message = message,
    data = data
)
