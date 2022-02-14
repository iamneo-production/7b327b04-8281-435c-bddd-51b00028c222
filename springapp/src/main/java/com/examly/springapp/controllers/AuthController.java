package com.examly.springapp.controllers;

import com.examly.springapp.database.entities.User;
import com.examly.springapp.exceptions.EmailTakenException;
import com.examly.springapp.models.UserModel;
import com.examly.springapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/user/signup")
    public ResponseEntity<?> saveUser(@RequestBody UserModel userModel) {

        try {
            return new ResponseEntity<User>(authService.saveUser(userModel), HttpStatus.CREATED);
        } catch (EmailTakenException e1) {
            return new ResponseEntity<String>("Email already taken. Try another one.", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/check_token_validity")
    public ResponseEntity<String> checkJwtValidity(){
        return new ResponseEntity<>("Token Valid", HttpStatus.OK);
    }

}
