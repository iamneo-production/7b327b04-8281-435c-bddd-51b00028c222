package com.examly.springapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.examly.springapp.database.entities.User;
import com.examly.springapp.database.repositories.UserRepo;
import com.examly.springapp.models.UserModel;
import com.examly.springapp.database.enums.Role;
import java.time.LocalDate;

@Service
public class userServ {
	@Autowired
	public UserRepo ur;
    @Autowired
    private PasswordEncoder passwordEncoder;
	public User user;


	public List<User> getUser(){
		List<User> user=new ArrayList<>();
		ur.findAll().forEach(user::add);
		return user;
	}

	// public List<User> getOnlineUser() {
	// 	List<User> onlineuser=new ArrayList<>();
	// 	ur.findByActive(true).forEach(onlineuser::add);
	// 	return onlineuser;
	// }

	// public ResponseEntity<?> userEditSave(User user) {
	// 	HashMap<String, String> h=new HashMap<>();
	// 	ur.save(user);
	// 	login l=new login(user.getEmail(),user.getPassword());
	// 	lr.save(l);
	// 	h.put("Message", "User added successfully");
	// 	return ResponseEntity.ok(h);
	// }

	// public ResponseEntity<?> userEdit(UserModel userModel, String id) {
	// 	ur.save(new User(
    //         userModel.getUsername(),
    //         userModel.getEmail(),
    //         passwordEncoder.encode(userModel.getPassword()),
    //         userModel.getMobileNumber(),
    //         true,
    //         Role.CUSTOMER,
    //         LocalDate.now()
    //     ));
	// 	HashMap<String, String> h=new HashMap<>();
	// 	h.put("Message", "User edited successfully");
	// 	return ResponseEntity.ok(h);
	// }

	public ResponseEntity<?> userDelete(String id) {
		//lr.deleteById(ur.findById(id).get().getEmail());
		ur.deleteById(id);
		HashMap<String, String> h=new HashMap<>();
		h.put("Message", "User deleted successfully");
		return ResponseEntity.ok(h);
	}

	public User getUser(String id) {
		return ur.findById(id).orElse(null);
	}

}