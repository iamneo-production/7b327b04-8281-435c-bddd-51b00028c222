package com.examly.springapp.controllers;

import com.examly.springapp.database.entities.User;
import com.examly.springapp.exceptions.EmailTakenException;
import com.examly.springapp.models.UserModel;
import com.examly.springapp.security.JwtManager;
import com.examly.springapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class AuthController {

    private final AuthService authService;
    private final JwtManager jwtManager;

    @Autowired
    public AuthController(AuthService authService, JwtManager jwtManager) {
        this.authService = authService;
        this.jwtManager = jwtManager;
    }

    @PostMapping(path = "/user/signup")
    public ResponseEntity<?> saveUser(HttpServletRequest request, @RequestBody UserModel userModel) {

        try {
            User user = authService.saveUser(userModel);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
            String accessToken = jwtManager.generateAccessToken(user.getEmail(), request.getRequestURL().toString(), authorities);
            UserModel userResponseDetails = new UserModel(
                    user.getEmail(),
                    null,
                    user.getUsername(),
                    user.getMobileNumber(),
                    user.getRole()
            );
            return new ResponseEntity<>(new SignupResponse(accessToken, userResponseDetails), HttpStatus.CREATED);
        } catch (EmailTakenException e1) {
            return new ResponseEntity<String>("Email already taken. Try another one.", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/check_token_validity")
    public ResponseEntity<String> checkJwtValidity() {
        return new ResponseEntity<>("Token Valid", HttpStatus.OK);
    }

    static class SignupResponse {
        private String accessToken;
        private UserModel user;

        public SignupResponse(String accessToken, UserModel user) {
            this.accessToken = accessToken;
            this.user = user;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public UserModel getUser() {
            return user;
        }

        public void setUser(UserModel user) {
            this.user = user;
        }
    }
}
