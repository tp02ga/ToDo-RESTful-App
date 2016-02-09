package com.coderscampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.domain.User;

public interface UserRepository extends JpaRepository<User, Long>
{
  public User findByUsername(String username);
}
