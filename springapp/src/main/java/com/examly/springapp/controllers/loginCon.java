package com.examly.springapp.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.MyUserDetailsService;
//import com.examly.springapp.models.AuthenticationResponse;
import com.examly.springapp.models.JwtUtil;
import com.examly.springapp.models.login;
import com.examly.springapp.models.user;
import com.examly.springapp.repositories.userRepo;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class loginCon {
	public login login;
	@Autowired
	public userRepo ur;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody user user) throws Exception {
		HashMap <String, String> h=new HashMap<>();
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			h.put("Status", "false");
			h.put("Message", "Invalid credentials");
			return ResponseEntity.ok(h);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(user.getEmail());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		h.put("jwt", jwt);
		h.put("Status", "true");
		h.put("Message", "Logged in successfully");
		String username=ur.findByEmail(user.getEmail()).get().getUsername();
		h.put("username",username);
		h.put("email",user.getEmail());
		String id=ur.findByEmail(user.getEmail()).get().getId();
		String r=ur.findByEmail(user.getEmail()).get().getRole();
		h.put("id",id);
		h.put("role",r);
		return ResponseEntity.ok(h);
	}

}
