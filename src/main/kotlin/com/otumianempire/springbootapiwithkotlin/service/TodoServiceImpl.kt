package com.otumianempire.springbootapiwithkotlin.service

import com.otumianempire.springbootapiwithkotlin.dto.TodoDto
import com.otumianempire.springbootapiwithkotlin.repository.TodoRepository
import com.otumianempire.springbootapiwithkotlin.utils.exception.TodoException
import com.otumianempire.springbootapiwithkotlin.utils.mapper.TodoMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository, private val todoMapper: TodoMapper
) : TodoService {
    override fun createTodo(todoDto: TodoDto): TodoDto {
//        if (todoDto.id.toString().isNotEmpty() || todoDto.id.toString().isNotBlank()) {
//            throw Exception("Id not needed")
//        }

        val entity = todoMapper.fromDtoToEntity(todoDto)
        todoRepository.save(entity)

        return todoMapper.fromEntityToDto(entity)
    }

    override fun getTodos(): List<TodoDto> {
        return todoRepository.findAll().map {
            todoMapper.fromEntityToDto(it)
        }
    }

    override fun getTodoById(id: Int): TodoDto {
        val todo = todoRepository.findByIdOrNull(id) ?: throw TodoException("Todo not found")
        return todoMapper.fromEntityToDto(todo)
    }

    override fun updateTodo(todoId: Int, todo: TodoDto): TodoDto? {
        val existingTodo = todoRepository.findByIdOrNull(todoId) ?: throw TodoException("Todo not found")
        existingTodo.task = todo.task
        existingTodo.isDone = todo.isDone
        todoRepository.save(existingTodo)

        return todoMapper.fromEntityToDto(existingTodo)
    }

    override fun deleteTodoById(id: Int) {
        todoRepository.findByIdOrNull(id) ?: throw TodoException("Todo not found")
        todoRepository.deleteById(id)
    }
}