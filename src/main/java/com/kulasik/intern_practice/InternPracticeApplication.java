package com.kulasik.intern_practice;

import com.kulasik.intern_practice.student.Student;
import com.kulasik.intern_practice.student.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class InternPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternPracticeApplication.class, args);
    }

    @Bean
    CommandLineRunner initDB(StudentService studentService) {
        return args -> {
            studentService.addStudent(new Student("Mariusz", "Kowalski", LocalDate.now().minusYears(10)));
            studentService.addStudent(new Student("Szymon", "Malczewski", LocalDate.now().minusYears(13)));
            studentService.addStudent(new Student("Mariusz", "Pudzianowski", LocalDate.now().minusYears(34)));
        };
    }
}
