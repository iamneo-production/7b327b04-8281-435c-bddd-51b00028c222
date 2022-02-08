package com.examly.springapp;

import com.examly.springapp.database.entities.User;
import com.examly.springapp.database.enums.Role;
import com.examly.springapp.database.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class SpringappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringappApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepo.findByEmail("admin@mail.com").isEmpty()) {
                User rootAdmin = new User("admin", "admin@mail.com", passwordEncoder().encode("admin"), null, true, Role.ADMIN, LocalDate.now());
                userRepo.save(rootAdmin);

            }
        };
    }

}