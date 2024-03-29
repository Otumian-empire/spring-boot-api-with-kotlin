package com.otumianempire.springbootapiwithkotlin.web.rest

import com.otumianempire.springbootapiwithkotlin.dto.TodoDto
import com.otumianempire.springbootapiwithkotlin.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TodoResource(private val todoService: TodoService) {
    @PostMapping
    fun createTodo(@RequestBody todoDto: TodoDto): ResponseEntity<TodoDto> {
        return ResponseEntity(todoService.createTodo(todoDto), HttpStatus.CREATED)
    }

    @GetMapping("/todos")
    fun readTodos(): ResponseEntity<List<TodoDto>> {
        return ResponseEntity(todoService.getTodos(), HttpStatus.OK)
    }

    @GetMapping("/todos/{id}")
    fun readTodo(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity(todoService.getTodoById(id), HttpStatus.OK)
    }

    @PutMapping("/todos/{id}")
    fun updateTodo(@PathVariable id: Int, @RequestBody todoDto: TodoDto): ResponseEntity<TodoDto> {
        val todo = todoService.updateTodo(id, todoDto)
        if (todo !== null) {
            return ResponseEntity(todo, HttpStatus.OK)
        }

        throw Exception("Could not update todo of id: $id")
    }

    @DeleteMapping("/todos/{id}")
    fun deleteTodo(@PathVariable id: Int): ResponseEntity<Unit> {
        return ResponseEntity(todoService.deleteTodoById(id), HttpStatus.NO_CONTENT)
    }
}