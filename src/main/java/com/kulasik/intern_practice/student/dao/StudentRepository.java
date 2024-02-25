package com.kulasik.intern_practice.student.dao;

import com.kulasik.intern_practice.student.Student;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;
interface StudentRepository extends ListCrudRepository<Student, UUID> {

}
