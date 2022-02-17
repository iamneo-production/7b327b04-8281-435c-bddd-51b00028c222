package com.examly.springapp.database.repositories;

import com.examly.springapp.database.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, String> {
}
