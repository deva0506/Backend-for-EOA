package com.example.review1.model;





import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
    @Id
    private String userName;
    private int eid;
    private String password;
    
    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getuserName() {
        return userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    
    public User( String userName, String password,int eid) {
        
        this.userName = userName;
        this.password = password;
        this.eid=eid;
        
    }
    public User() {
    }
  
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL )
    @JsonManagedReference
    private Event eve;

    public Event getEve() {
        return eve;
    }
    public void setEve(Event eve) {
        this.eve = eve;
    }

}