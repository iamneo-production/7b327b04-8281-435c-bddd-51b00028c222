package com.examly.springapp.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.models.login;
import com.examly.springapp.models.user;
import com.examly.springapp.repositories.loginRepo;
import com.examly.springapp.repositories.userRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class signupCon {
	public user user;
	@Autowired
	public userRepo ur;
	@Autowired
	public loginRepo lr;
	@RequestMapping(method=RequestMethod.POST, value="/signup")
	ResponseEntity<?> saveUser(@RequestBody user user) {
		HashMap<String, String> h=new HashMap<>();
		if(lr.existsById(user.getEmail())) {
			h.put("Status", "false");
			h.put("Message", "User already exists");
			return ResponseEntity.ok(h);
		}
		else {
			ur.save(user);
			login l=new login(user.getEmail(),user.getPassword());
			lr.save(l);
			h.put("Status", "true");
			h.put("Message", "User registered successfully");
			return ResponseEntity.ok(h);
		}
	}
}
