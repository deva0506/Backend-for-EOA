package com.example.review1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.review1.model.Login;

public interface LoginRepo extends JpaRepository<Login,String>{
    
}