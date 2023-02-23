package com.anderson.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anderson.project.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
