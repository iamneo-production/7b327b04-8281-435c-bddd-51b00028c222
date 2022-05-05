package com.examly.springapp.database.repositories;

import com.examly.springapp.database.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<Menu, String> {
}
