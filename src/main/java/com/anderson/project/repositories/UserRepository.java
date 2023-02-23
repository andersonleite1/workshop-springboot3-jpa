package com.anderson.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.project.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
