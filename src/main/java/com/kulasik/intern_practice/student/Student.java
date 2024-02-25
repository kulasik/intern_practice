package com.kulasik.intern_practice.student;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "student")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@JsonIgnoreProperties(value = "id", allowGetters = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private LocalDate dateOfBirth;


}
