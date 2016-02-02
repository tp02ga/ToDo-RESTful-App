package com.coderscampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.domain.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long>
{

}
