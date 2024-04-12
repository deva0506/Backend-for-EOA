package com.example.review1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.review1.model.User;
import com.example.review1.repository.UserRepo;


@Service
public class UserService {
    @Autowired
    UserRepo ur;
    public User create(User u)
{ 
        return ur.save(u);
    }
    public List<User> getAllDetails()
    {
        return ur.findAll();
    }
    public User getMe(String id)
    {
        return ur.findById(id).orElse(null);
    }
    public boolean updateDetails(String email,User mm)
    {
        if(this.getMe(email)==null)
        {
            return false;
        }
        try{
            ur.save(mm);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
public boolean deleteLogin(String email)
    {
        if(this.getMe(email) == null)
        {
            return false;
        }
        ur.deleteById(email);
        return true;
    }
}