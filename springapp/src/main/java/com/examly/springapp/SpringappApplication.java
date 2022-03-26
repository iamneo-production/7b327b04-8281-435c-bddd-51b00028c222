package com.examly.springapp;

import com.examly.springapp.database.entities.AddOn;
import com.examly.springapp.database.entities.Menu;
import com.examly.springapp.database.entities.Theme;
import com.examly.springapp.database.entities.User;
import com.examly.springapp.database.enums.Role;
import com.examly.springapp.database.repositories.AddOnRepo;
import com.examly.springapp.database.repositories.MenuRepo;
import com.examly.springapp.database.repositories.ThemeRepo;
import com.examly.springapp.database.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    CommandLineRunner runner(UserRepo userRepo, PasswordEncoder passwordEncoder, ThemeRepo themeRepo, MenuRepo menuRepo, AddOnRepo addOnRepo) {
        return args -> {
            Optional<User> byEmail = userRepo.findByEmail("admin@mail.com");
            User rootAdmin = null;
            if (byEmail.isEmpty()) {
                rootAdmin = new User("admin", "admin@mail.com", passwordEncoder().encode("admin"), null, true, Role.ADMIN, LocalDate.now());

            } else {
                rootAdmin = byEmail.get();
                rootAdmin.setActive(true);
            }
            userRepo.save(rootAdmin);

            // Adding Themes
            for (int i = 0; i < 5; i++) {
                Theme theme = new Theme(
                        "Theme "+i,
                        "some Image",
                        "theme Desc",
                        "theme photog",
                        "themevideog",
                        "return gifdt",
                        22D,
                        LocalDate.now(),
                        rootAdmin
                );
                themeRepo.save(theme);
            }
            // Adding Menus
            for(int i=0;i<5;i++){
                Menu menu = new Menu(
                        "Some type"+i,
                        "items",
                        12D,
                        LocalDate.now(),
                        rootAdmin
                );
                menuRepo.save(menu);
            }
            // Adding AddOns
            for(int i=0;i<5;i++)
            {
                AddOn addOn = new AddOn(
                        "addOn"+i,
                        "desc",
                        10D,
                        LocalDate.now(),
                        rootAdmin
                );
                addOnRepo.save(addOn);
            }

        };
    }

}