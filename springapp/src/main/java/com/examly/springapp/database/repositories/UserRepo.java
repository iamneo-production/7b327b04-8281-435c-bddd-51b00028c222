package com.examly.springapp.database.repositories;

import com.examly.springapp.database.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    public List<User> findByActive(boolean active);

    Optional<User> findByEmail(String email);
// 	@Modifying
// 	@Transactional
// 	@Query("update user u set u.email=?1, u.password=?2, u.username=?3, u.mobile_number=?4 where u.id=?5")
// 	void updateUser(String email, String password, String username, String mobileNumber, String id);
 }