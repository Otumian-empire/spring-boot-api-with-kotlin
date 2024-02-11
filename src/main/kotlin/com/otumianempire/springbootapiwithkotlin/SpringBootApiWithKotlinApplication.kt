package com.otumianempire.springbootapiwithkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class SpringBootApiWithKotlinApplication {
	@GetMapping
	fun helloWorld() = "Hello world"
}

fun main(args: Array<String>) {
	runApplication<SpringBootApiWithKotlinApplication>(*args)
}
