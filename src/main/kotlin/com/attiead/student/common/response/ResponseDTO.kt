package com.attiead.student.common.response

import com.attiead.student.common.model.MetaCode

data class ResponseDTO<T>(
    override val meta: Meta,
    override val data: T? = null
) : AbstractResponseDTO<T>(meta, data) {

    companion object {
        fun <T> success(meta: Meta, data: T? = null): ResponseDTO<T> =
            ResponseDTO(
                meta = meta,
                data = data
            )

        fun <T> success(metaCode: MetaCode, data: T? = null): ResponseDTO<T> =
            success(
                meta = Meta(code = metaCode),
                data = data
            )

        fun <T> success(data: T? = null): ResponseDTO<T> =
            success(
                metaCode = MetaCode.SUCCESS,
                data = data
            )
    }
}
