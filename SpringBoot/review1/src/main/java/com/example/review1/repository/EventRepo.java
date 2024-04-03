package com.example.review1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.review1.model.Event;
public interface EventRepo extends JpaRepository<Event,Integer> {

}
