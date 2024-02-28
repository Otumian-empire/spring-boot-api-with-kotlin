package com.otumianempire.springbootapiwithkotlin.utils.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(TodoException::class)
    fun todoExceptionHandler(exception: TodoException): ResponseEntity<ApiError> {
        val error = ApiError(message = exception.message)
        println(error)
        return ResponseEntity(error, error.status)
    }


}