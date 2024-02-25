package com.kulasik.intern_practice.student.dao;


import com.kulasik.intern_practice.student.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("jpa")
class StudentJPADao implements StudentDao{

    private final StudentRepository studentRepository;

    public StudentJPADao(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Optional<Student> selectStudentById(UUID id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> selectAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void insertStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(UUID id) {
        studentRepository.deleteById(id);
    }

    @Override
    public boolean checkIfExistsStudentById(UUID id) {
        return studentRepository.existsById(id);
    }
}
