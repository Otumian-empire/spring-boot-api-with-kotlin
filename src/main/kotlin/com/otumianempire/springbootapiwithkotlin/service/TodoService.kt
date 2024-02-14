package com.otumianempire.springbootapiwithkotlin.service

import com.otumianempire.springbootapiwithkotlin.dto.TodoDto

interface TodoService {
    fun createTodo(todoDto: TodoDto): TodoDto
    fun getTodos(): List<TodoDto>
    fun getTodoById(id: Int): TodoDto
    fun updateTodo(todoId: Int, todo: TodoDto): TodoDto?
    fun deleteTodoById(id: Int)
}

