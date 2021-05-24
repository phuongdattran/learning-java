package com.example.demo.config;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User bruce = new User(
                    "bruce",
                    "batman@gmail.com",
                    LocalDate.of(1980, Month.MAY, 2)
            );

            User clark = new User(
                    "clark",
                    "superman@gmail.com",
                    LocalDate.of(1985, Month.JANUARY, 6)
            );

            repository.saveAll((List.of(bruce, clark)));
        };
    }

}
