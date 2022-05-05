package com.examly.springapp.database.repositories;

import com.examly.springapp.database.entities.Event;
import com.examly.springapp.database.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, String> {

    @Query("SELECT e FROM Event e where e.bookedBy=:user")
    List<Event> findByUser(User user);
}
