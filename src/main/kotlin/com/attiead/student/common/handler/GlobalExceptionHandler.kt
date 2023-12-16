package com.attiead.student.common.handler

import com.attiead.student.common.exception.BaseHttpException
import com.attiead.student.common.exception.ConflictException
import com.attiead.student.common.exception.InternalServerException
import com.attiead.student.common.exception.InvalidException
import com.attiead.student.common.exception.NotFoundException
import com.attiead.student.common.exception.RemoteCallException
import com.attiead.student.common.exception.UnprocessableException
import com.attiead.student.common.logback.Log
import com.attiead.student.common.model.MetaCode
import com.attiead.student.common.response.Meta
import com.attiead.student.common.response.ResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    companion object : Log

    @ExceptionHandler(
        value = [
            (InvalidException::class),
            (ConflictException::class),
            (NotFoundException::class),
            (InternalServerException::class),
        ]
    )
    fun handleBaseHttpException(error: BaseHttpException):
        ResponseEntity<ResponseDTO<Any>> {
        val status = when (error) {
            is InvalidException -> HttpStatus.BAD_REQUEST
            is ConflictException -> HttpStatus.CONFLICT
            is NotFoundException -> HttpStatus.NOT_FOUND
            is InternalServerException -> HttpStatus.INTERNAL_SERVER_ERROR
            else -> HttpStatus.INTERNAL_SERVER_ERROR
        }

        return createErrorResponse(statusCode = status, message = error.message, data = error.data)
    }

    @ExceptionHandler(
        value = [
            (Exception::class)
        ]
    )
    fun handleUnhandledException(error: Exception):
        ResponseEntity<ResponseDTO<Any>> {
        logger.error(error.message, error)
        return createErrorResponse(
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR,
            message = error.message
        )
    }

    @ExceptionHandler(
        value = [
            (NotImplementedError::class)
        ]
    )
    fun handleNotImplementedError(request: ServerHttpRequest, error: NotImplementedError):
        ResponseEntity<ResponseDTO<Any>> {
        logger.error(error.message, error)
        return createErrorResponse(statusCode = HttpStatus.NOT_IMPLEMENTED, message = error.message)
    }

    @ExceptionHandler(
        value = [
            (RemoteCallException::class)
        ]
    )
    fun handleRemoteCallException(error: RemoteCallException):
        ResponseEntity<ResponseDTO<Any>> {
        logger.error(error.message, error)
        val status = error.remoteStatus ?: HttpStatus.INTERNAL_SERVER_ERROR
        return createErrorResponse(statusCode = status, message = error.message)
    }

    @ExceptionHandler(
        value = [
            (UnprocessableException::class)
        ]
    )
    fun handleUnprocessableError(error: UnprocessableException):
        ResponseEntity<ResponseDTO<Any>> {
        return createErrorResponse(statusCode = HttpStatus.UNPROCESSABLE_ENTITY, message = error.message)
    }

    fun createErrorResponse(statusCode: HttpStatus, message: String? = null, data: Any? = null):
        ResponseEntity<ResponseDTO<Any>> {
        val dtoMetaCode = MetaCode.valueFrom(statusCode)

        val dto = ResponseDTO(
            meta = Meta(
                code = dtoMetaCode,
                type = dtoMetaCode.name,
                message = message
            ),
            data = data
        )

        return ResponseEntity(dto, statusCode)
    }
}
