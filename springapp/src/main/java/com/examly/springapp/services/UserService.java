package com.examly.springapp.services;

import com.examly.springapp.database.entities.User;
import com.examly.springapp.database.repositories.UserRepo;
import com.examly.springapp.exceptions.EmailNotUpdatableException;
import com.examly.springapp.exceptions.UserNotFoundException;
import com.examly.springapp.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getUsers() {
        List<User> user = new ArrayList<>();
        userRepo.findAll().forEach(user::add);
        return user;
    }

    public User getUser(String id) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findById(id);
        userOptional.orElseThrow(UserNotFoundException::new);
        return userOptional.get();
    }

	@Transactional
    public User editUser(String id, UserModel userModel) throws UserNotFoundException, EmailNotUpdatableException {
        Optional<User> userOptional = userRepo.findById(id);
        userOptional.orElseThrow(UserNotFoundException::new);
		User user = userOptional.get();
		if(userModel.getUsername() != null && !Objects.equals(userModel.getUsername(), user.getUsername()))
			user.setUsername(userModel.getUsername());
		if (userModel.getEmail() !=null && !Objects.equals(userModel.getEmail(), user.getEmail()))
			throw new EmailNotUpdatableException();
		if (userModel.getPassword() !=null && !Objects.equals(passwordEncoder.encode(userModel.getPassword()), user.getPassword()))
			user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		if(userModel.getMobileNumber() != null && !Objects.equals(userModel.getMobileNumber(), user.getMobileNumber()))
			user.setMobileNumber(userModel.getMobileNumber());
		if(userModel.getUserRole() != null && userModel.getUserRole().compareTo(user.getRole())!=0)
			user.setRole(userModel.getUserRole());
		return user;
    }

    @Transactional
    public void deactivateUser(String id) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findById(id);
        userOptional.orElseThrow(UserNotFoundException::new);
        userOptional.get().setActive(false);
    }

    @Transactional
    public void activateUser(String id) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findById(id);
        userOptional.orElseThrow(UserNotFoundException::new);
        userOptional.get().setActive(true);
    }
}