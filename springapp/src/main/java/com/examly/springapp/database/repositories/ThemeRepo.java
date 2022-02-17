package com.examly.springapp.database.repositories;

import com.examly.springapp.database.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepo extends JpaRepository<Theme, String> {

}
