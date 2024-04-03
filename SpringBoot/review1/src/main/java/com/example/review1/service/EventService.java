package com.example.review1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.review1.repository.EventRepo;
import com.example.review1.model.Event;
@Service
public class EventService {
     @Autowired
     EventRepo ev;
     public Event create(Event e){
      return ev.save(e);
     }
     public List<Event> getAll(){
      return ev.findAll();
     }
     public Event getId(int eid){
      return ev.findById(eid).orElse(null);
     }
     public boolean update(int eid,Event ee){
          if(this.getId(eid)==null)
          {
              return false;
          }
          try{
              ev.save(ee);
          }
          catch(Exception e)
          {
              return false;
          }
          return  true;
     }
     public boolean delete(int eid){
          if(this.getId(eid)==null){
             return false;
          }
          ev.deleteById(eid);
          return true;
     }
}
