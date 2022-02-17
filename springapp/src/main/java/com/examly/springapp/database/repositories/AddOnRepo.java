package com.examly.springapp.database.repositories;

import com.examly.springapp.database.entities.AddOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddOnRepo extends JpaRepository<AddOn, String> {
}
