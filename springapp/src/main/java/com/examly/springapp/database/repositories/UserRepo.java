package com.examly.springapp.database.repositories;

import com.examly.springapp.database.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    public List<User> findByActive(boolean active);

    Optional<User> findByEmail(String email);
//	@Modifying
//	@Transactional
//	@Query("update user u set u.active=1 where u.email=?1")
//	void setActiveForUser(String email);
}