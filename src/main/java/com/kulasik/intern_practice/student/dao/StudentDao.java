package com.kulasik.intern_practice.student.dao;

import com.kulasik.intern_practice.student.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    Optional<Student> selectStudentById(UUID id);

    List<Student> selectAllStudents();

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(UUID id);

    boolean checkIfExistsStudentById(UUID id);
}
