package com.coderscampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.domain.ToDo;
import com.coderscampus.domain.User;

public interface ToDoRepository extends JpaRepository<ToDo, Long>
{
  public ToDo findByTaskAndUser(String task, User user);
}
