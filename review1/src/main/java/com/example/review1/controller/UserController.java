package com.example.review1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.review1.model.User;
import com.example.review1.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService ms;
    @PostMapping("/user")
    public ResponseEntity<User>addelements(@RequestBody User m)
    {
        User mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> showinfo()
    {
        return new ResponseEntity<>(ms.getAllDetails(),HttpStatus.OK);
    }
    @GetMapping("/user/{userName}")
    public ResponseEntity<User> getById(@PathVariable String userName)
    {
        User obj=ms.getMe(userName);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/user/{userName}")
    public ResponseEntity<User> putMethodName(@PathVariable("userName") String userName, @RequestBody User m) {
        if(ms.updateDetails(userName,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/user/{userName}")
    public ResponseEntity<Boolean> delete(@PathVariable("userName") String userName)
    {
        if(ms.deleteLogin(userName) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}