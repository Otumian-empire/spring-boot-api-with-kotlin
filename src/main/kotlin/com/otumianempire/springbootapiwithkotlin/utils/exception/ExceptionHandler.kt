package com.otumianempire.springbootapiwithkotlin.utils.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun todoExceptionHandler(exception: Exception): ResponseEntity<ApiError> {
        val error = ApiError(message = exception.message)
        return ResponseEntity(error, error.status)
    }
}