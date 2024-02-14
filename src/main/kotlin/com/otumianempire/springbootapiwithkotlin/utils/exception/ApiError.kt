package com.otumianempire.springbootapiwithkotlin.utils.exception

import org.springframework.http.HttpStatus

data class ApiError(
    val message: String? = "Something went wrong",
    val status: HttpStatus = HttpStatus.BAD_REQUEST
)
