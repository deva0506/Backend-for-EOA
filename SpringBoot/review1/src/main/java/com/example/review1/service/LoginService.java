package com.example.review1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.review1.model.Login;
import com.example.review1.repository.LoginRepo;


@Service
public class LoginService {
    @Autowired
    LoginRepo ur;
    public Login create(Login u)
    {
        return ur.save(u);
    }
    public List<Login> getAllDetails()
    {
        return ur.findAll();
    }
    public Login getMe(String id)
    {
        return ur.findById(id).orElse(null);
    }
    public boolean updateDetails(String email,Login mm)
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