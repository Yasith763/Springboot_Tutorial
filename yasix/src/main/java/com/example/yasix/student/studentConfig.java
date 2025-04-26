package com.example.yasix.student;

import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class studentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(studentRepository studentRepository) {
        return args -> {
            student yasix = new student(
                "John",
                "xxx@gmail.com",
                LocalDate.of(2000, Month.APRIL, 1)
            );

            student dineth = new student(
                "thadi",
                "aaa@gmail.com",
                LocalDate.of(2002, Month.APRIL, 30)
            );

            studentRepository.saveAll(
                List.of(yasix, dineth)
            );
            // studentRepository.saveAll(

        };
    }

}

