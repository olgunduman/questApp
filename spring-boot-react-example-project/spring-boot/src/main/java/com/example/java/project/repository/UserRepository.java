package com.example.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java.project.entity.User;

public interface UserRepository extends 
JpaRepository<User, Long> {

}
