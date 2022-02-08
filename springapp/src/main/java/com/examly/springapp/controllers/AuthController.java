package com.examly.springapp.controllers;

import com.examly.springapp.database.entities.User;
import com.examly.springapp.models.UserModel;
import com.examly.springapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/user/signup")
    public ResponseEntity<?> saveUser(@ModelAttribute UserModel userModel) {
        System.out.println(userModel);
        Optional<User> userOptional = authService.getUserByEmail(userModel.getEmail());
        if (userOptional.isPresent())
            return new ResponseEntity<String>("Email already taken. Try another one.", HttpStatus.FORBIDDEN);

        try {
            return new ResponseEntity<User>(authService.saveUser(userModel), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
