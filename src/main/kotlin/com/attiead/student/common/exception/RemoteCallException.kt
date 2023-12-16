package com.attiead.student.common.exception

import com.attiead.student.common.model.MetaCode
import org.springframework.http.HttpStatus

class RemoteCallException(
    val remoteStatus: HttpStatus? = null,
    val remoteMessage: String? = null
) : BaseHttpException(
    metaCode = MetaCode.INTERNAL_SERVER_ERROR,
    message = "$remoteStatus : $remoteMessage"
)
