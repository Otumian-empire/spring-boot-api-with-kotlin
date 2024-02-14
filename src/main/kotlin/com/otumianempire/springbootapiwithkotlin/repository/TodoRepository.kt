package com.otumianempire.springbootapiwithkotlin.repository

import com.otumianempire.springbootapiwithkotlin.entity.Todo
import org.springframework.data.repository.CrudRepository


interface TodoRepository : CrudRepository<Todo, Int>
