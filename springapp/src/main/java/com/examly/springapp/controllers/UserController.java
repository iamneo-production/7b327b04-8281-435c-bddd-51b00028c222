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
import org.springframework.web.bind.annotation.ModelAttribute;

import com.examly.springapp.database.entities.User;
import com.examly.springapp.database.repositories.UserRepo;
import com.examly.springapp.services.userServ;
import com.examly.springapp.models.UserModel;

@RestController
//@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {
	
	@Autowired
	public userServ us;
	@Autowired
	public UserRepo ur;
	// @RequestMapping("/home")
	// public User hello(Authentication authentication){
	// 	return ur.findByEmail(authentication.getName()).get();
	// }

	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public List<User> getUser(){
		return us.getUser();
	}
	// @RequestMapping(method=RequestMethod.PUT, value="/admin/userEdit/{id}")
	// ResponseEntity<?> userEdit(@ModelAttribute UserModel userModel, @PathVariable String id) {
	// 	//userEditSave(us.userEdit(id));
	// 	return us.userEdit(userModel,id);
	// }
	//@RequestMapping(method=RequestMethod.POST, value="/admin/addUser")
	//ResponseEntity<?> userEditSave(@RequestBody User user){
		//return us.userEditSave(user);
	//}
	@RequestMapping(method=RequestMethod.DELETE, value="/admin/delete/{id}")
	ResponseEntity<?> userDelete(@PathVariable String id) {
		//userEditSave(us.userEdit(id));
		return us.userDelete(id);
	}
}
