package com.examly.springapp.database.repositories;

import com.examly.springapp.models.ThemeModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepo extends JpaRepository<ThemeModel, Integer>
{
    
}
