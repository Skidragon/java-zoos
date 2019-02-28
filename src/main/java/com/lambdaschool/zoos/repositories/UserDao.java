package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}