package com.examly.springapp.repositories;

import java.util.List;
import java.util.Optional;
//import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.examly.springapp.models.user;

public interface userRepo extends CrudRepository<user, String> {
	public List<user> findByActive(boolean active);
	Optional<user> findByEmail(String email);
	@Modifying
	@Transactional
	@Query("update user u set u.active=1 where u.email=?1")
	void setActiveForUser(String email);
}