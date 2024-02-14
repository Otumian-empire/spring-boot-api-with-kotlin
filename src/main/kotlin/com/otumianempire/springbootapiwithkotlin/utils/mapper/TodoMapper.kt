package com.otumianempire.springbootapiwithkotlin.utils.mapper

import com.otumianempire.springbootapiwithkotlin.dto.TodoDto
import com.otumianempire.springbootapiwithkotlin.entity.Todo
import com.otumianempire.springbootapiwithkotlin.utils.mapper.Mapper
import org.springframework.stereotype.Service

@Service
class TodoMapper : Mapper<TodoDto, Todo> {
    override fun fromEntityToDto(entity: Todo): TodoDto {
        return TodoDto(
                entity.id,
                entity.task,
                entity.isDone
        )
    }

    override fun fromDtoToEntity(dto: TodoDto): Todo {
        return Todo(
                dto.id,
                dto.task,
                dto.isDone
        )
    }

}

// Route Layer (Calls Controllers and Middlewares)
// Controller Layer (Calls services)
// Service Layer (Validation and Business Logic)
// Persistence Layer (Responsible for handling database operations)