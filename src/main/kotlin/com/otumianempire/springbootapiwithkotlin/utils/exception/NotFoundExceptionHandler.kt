package com.otumianempire.springbootapiwithkotlin.utils.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class NotFoundExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun todoExceptionHandler(exception: Exception): ResponseEntity<ApiError> {
        val error = ApiError(message = "Requested resource not found", HttpStatus.NOT_FOUND)
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }
}