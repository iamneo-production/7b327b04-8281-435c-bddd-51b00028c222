package com.examly.springapp.controllers;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.examly.springapp.models.user;
import com.examly.springapp.repositories.userRepo;
import com.examly.springapp.services.userServ;

@RestController
//@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {
	
	@Autowired
	public userServ us;
	@Autowired
	public userRepo ur;
	//@RequestMapping("/home")
	/*public user hello(Authentication authentication){
		return ur.findByEmail(authentication.getName()).get();
	}*/
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public List<user> getUser(){
		return us.getUser();
	}
	@RequestMapping(method=RequestMethod.PUT, value="/admin/userEdit/{id}")
	ResponseEntity<?> userEdit(@RequestBody user user, @PathVariable String id) {
		//userEditSave(us.userEdit(id));
		return us.userEdit(user,id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/admin/addUser")
	ResponseEntity<?> userEditSave(@RequestBody user user){
		return us.userEditSave(user);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/admin/delete/{id}")
	ResponseEntity<?> userDelete(@PathVariable String id) {
		//userEditSave(us.userEdit(id));
		return us.userDelete(id);
	}
}
