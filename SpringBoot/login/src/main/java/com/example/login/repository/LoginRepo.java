package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.model.Login;




public interface LoginRepo extends JpaRepository<Login,String>{
    
}