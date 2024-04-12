package com.example.review1.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.lang.String;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        //sorting by field
        public List<Event> sort(String field)
        {
            Sort sort=Sort.by(Sort.Direction.ASC,field);
            return ev.findAll(sort);
        }
    
        //pagination
        public List<Event> page(int pageSize,int pageNumber)
        {
            Pageable page=PageRequest.of(pageNumber, pageSize);
            return ev.findAll(page).getContent();
        }
    
        //sorting and pagination
        public List<Event> getsort(int pageNumber,int pageSize,String field)
        {          return ev.findAll(PageRequest.of(pageNumber, pageSize)
              .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
        }
        public List<Event> getUsersWithStateEvents() {
            return ev.findByState();
        }
}
