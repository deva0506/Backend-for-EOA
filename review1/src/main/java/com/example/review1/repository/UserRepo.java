package com.example.review1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.review1.model.User;

public interface UserRepo extends JpaRepository<User,String>{
    
}