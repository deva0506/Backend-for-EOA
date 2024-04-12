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

import com.example.review1.model.Event;
import com.example.review1.service.EventService;


@RestController
public class EventController {
    @Autowired
    EventService ev;
    @PostMapping("/post/event")
    public ResponseEntity<Event>addelements(@RequestBody Event m)
    {
        Event evt=ev.create(m);
        return new ResponseEntity<>(evt,HttpStatus.CREATED);
    }
    @GetMapping("/get/event")
    public ResponseEntity<List<Event>> showinfo()
    {
        return new ResponseEntity<>(ev.getAll(),HttpStatus.OK);
    }
    @GetMapping("/get/event/{eid}")
    public ResponseEntity<Event> getById(@PathVariable Integer eid)
    {
        Event obj=ev.getId(eid);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/put/{eid}")
    public ResponseEntity<Event> putMethodName(@PathVariable("eid") int eid, @RequestBody Event e) {
        if(ev.update(eid,e) == true)
        {
            return new ResponseEntity<>(e,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{eid}")
    public ResponseEntity<Boolean> delete(@PathVariable("eid") int eid)
    {
        if(ev.delete(eid) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
     //sorting
     @GetMapping("/sortby/{field}")
     public List<Event> g(@PathVariable String field)
     {
         return ev.sort(field);
     }
  
     //pagination
     @GetMapping("/api/{offset}/{pagesize}")
     public List<Event> get(@PathVariable int offset,@PathVariable int pagesize)
     {
         return ev.page(pagesize, offset);
     }
     
     //sorting and pagination
     @GetMapping("/api/{offset}/{pagesize}/{field}")
     public List<Event> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
     {
         return ev.getsort(offset,pagesize,field);
     }
     @GetMapping("/state")
     public List<Event> getUsersWithStateEvents() {
         return ev.getUsersWithStateEvents();
     }
 
}