package com.examly.springapp;

import com.examly.springapp.database.entities.*;
import com.examly.springapp.database.enums.EventState;
import com.examly.springapp.database.enums.Role;
import com.examly.springapp.database.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
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
    CommandLineRunner runner(UserRepo userRepo, PasswordEncoder passwordEncoder, ThemeRepo themeRepo, MenuRepo menuRepo, AddOnRepo addOnRepo, EventRepo eventRepo) {
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

            // Adding demo customers
            List<User> users = new ArrayList<>();
            for(int i=0;i<5;i++)
            {
                User user = new User("customer"+i, "customer"+i+"@mail.com", passwordEncoder.encode("customer"), null, true, Role.CUSTOMER, LocalDate.now());
                userRepo.save(user);
                users.add(user);
            }


            // Adding Themes
            List<Theme> themes = new ArrayList<>();
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
                themes.add(theme);
            }
            // Adding Menus
            List<Menu> menus = new ArrayList<>();
            for(int i=0;i<5;i++){
                Menu menu = new Menu(
                        "Some type"+i,
                        "items",
                        12D,
                        LocalDate.now(),
                        rootAdmin
                );
                menuRepo.save(menu);
                menus.add(menu);
            }
            // Adding AddOns
            List<AddOn> addOns = new ArrayList<>();
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
                addOns.add(addOn);
            }

            // Adding Some Events

            List<Event> events = new ArrayList<>();
            for(int i=0;i<5;i++)
            {
                List<AddOn> addOnList = List.of(addOns.get((int) (Math.random()*5)),
                        addOns.get((int) (Math.random()*5)));
                Event event = new Event(
                        "event"+i,
                        "Some Applicant",
                        "sdf",
                        ":dfg",
                        "sdfsdf",
                        "sdfg",
                        LocalDate.now(),
                        LocalTime.now(),
                        themes.get((int) (Math.random()*5)),
                        menus.get((int) (Math.random()*5)),
                        200D,
                        LocalDate.now(),
                        users.get((int) (Math.random()*5)),
                        addOnList,
                        EventState.BOOKED

                );
                eventRepo.save(event);
                events.add(event);
            }

        };

    }

}