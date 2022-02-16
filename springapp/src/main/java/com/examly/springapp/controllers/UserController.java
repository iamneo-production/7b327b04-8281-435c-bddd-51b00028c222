package com.examly.springapp.controllers;

import com.examly.springapp.database.entities.User;
import com.examly.springapp.exceptions.EmailNotUpdatableException;
import com.examly.springapp.exceptions.EmailTakenException;
import com.examly.springapp.exceptions.UserNotFoundException;
import com.examly.springapp.models.UserModel;
import com.examly.springapp.services.AuthService;
import com.examly.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        users.forEach(user -> user.setPassword(null));
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String userId){
        try {
            return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>("User not found with ID: "+userId, HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/user/add")
    public ResponseEntity<?> addUser(@RequestBody UserModel userModel){
        try {
            return new ResponseEntity<User>(authService.saveUser(userModel), HttpStatus.CREATED);
        } catch (EmailTakenException e1) {
            return new ResponseEntity<String>("Email already taken. Try another one.", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     @RequestMapping(method=RequestMethod.PUT, value="/user/{id}/edit")
     ResponseEntity<?> editUser(@PathVariable("id") String id, @RequestBody UserModel userModel) {

         try {
             return new ResponseEntity<>(userService.editUser(id, userModel), HttpStatus.OK);
         } catch (UserNotFoundException e) {
             return new ResponseEntity<String>("User not found with ID: "+id, HttpStatus.NOT_FOUND);
         } catch (EmailNotUpdatableException e) {
             return new ResponseEntity<String>("Email Cannot be updated.", HttpStatus.FORBIDDEN);
         } catch(Exception e){
             return new ResponseEntity<String>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}/deactivate")
    ResponseEntity<String> deactivateUser(@PathVariable("id") String id, @RequestAttribute("user_id") String user_id) {
        try {
            if(user_id.equals(id))
                return new ResponseEntity<>("You cannot deactivate youself", HttpStatus.FORBIDDEN);
            userService.deactivateUser(id);
            return new ResponseEntity<>("User Deactivated Successfully with ID: " + id, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("Couldn't find the user with ID: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}/activate")
    ResponseEntity<String> activateUser(@PathVariable("id") String id, @RequestAttribute("user_id") String user_id) {
        try {
            if(user_id.equals(id))
                return new ResponseEntity<>("You cannot Activate youself", HttpStatus.FORBIDDEN);
            userService.activateUser(id);
            return new ResponseEntity<>("User Activated Successfully with ID: " + id, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("Couldn't find the user with ID: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong on our side. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
