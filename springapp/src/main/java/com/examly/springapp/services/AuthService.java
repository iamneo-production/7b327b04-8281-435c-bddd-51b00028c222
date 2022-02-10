package com.examly.springapp.services;

import com.examly.springapp.database.entities.User;
import com.examly.springapp.database.enums.Role;
import com.examly.springapp.database.repositories.UserRepo;
import com.examly.springapp.exceptions.EmailTakenException;
import com.examly.springapp.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public User saveUser(UserModel userModel) throws EmailTakenException {
        Optional<User> userOptional = getUserByEmail(userModel.getEmail());
        if (userOptional.isPresent())
            throw new EmailTakenException();
        return userRepo.save(new User(
                userModel.getUsername(),
                userModel.getEmail(),
                passwordEncoder.encode(userModel.getPassword()),
                userModel.getMobileNumber(),
                true,
                Role.CUSTOMER,
                LocalDate.now()
        ));
    }

}
