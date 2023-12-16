package com.attiead.student.common.exception

import com.attiead.student.common.model.MetaCode

open class BaseHttpException(
    val metaCode: MetaCode = MetaCode.INTERNAL_SERVER_ERROR,
    override var message: String? = null,
    val data: Any? = null
) : RuntimeException()
