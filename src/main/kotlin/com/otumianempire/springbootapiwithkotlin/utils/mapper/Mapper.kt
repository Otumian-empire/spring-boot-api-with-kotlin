package com.otumianempire.springbootapiwithkotlin.utils.mapper

import com.otumianempire.springbootapiwithkotlin.dto.TodoDto

interface Mapper<Dto, Entity> {
    fun fromEntityToDto(entity: Entity): Dto
    fun fromDtoToEntity(dto: TodoDto): Entity
}