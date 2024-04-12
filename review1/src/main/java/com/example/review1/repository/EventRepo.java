package com.example.review1.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.review1.model.Event;
public interface EventRepo extends JpaRepository<Event,Integer> {
  @Query("SELECT e FROM Event e WHERE e.state='TamilNadu'")
  List<Event> findByState();

}
