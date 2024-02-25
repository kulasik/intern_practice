package com.kulasik.intern_practice.student.service;

import com.kulasik.intern_practice.student.Student;
import com.kulasik.intern_practice.student.dao.StudentDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(@Qualifier("jpa") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudentById(UUID id) {
        return studentDao.selectStudentById(id).orElseThrow(RuntimeException::new);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public void addStudent(Student student) {
        studentDao.insertStudent(student);
    }

    public void updateStudent(Student updateStudent) {
        Student student = studentDao.selectStudentById(updateStudent.getId())
                .orElseThrow(RuntimeException::new);

        boolean changes = false;

        if (student.getFirstName().equals(updateStudent.getFirstName())) {
            student.setFirstName(updateStudent.getFirstName());
            changes = true;
        }

        if (student.getLastName().equals(updateStudent.getLastName())) {
            student.setLastName(updateStudent.getLastName());
            changes = true;
        }

        if (student.getDateOfBirth().equals(updateStudent.getDateOfBirth())) {
            student.setDateOfBirth(updateStudent.getDateOfBirth());
            changes = true;
        }

        if (!changes) {
            throw new RuntimeException();
        }

        studentDao.updateStudent(student);

    }

    public void deleteStudentById(UUID id) {
        checkIfStudentExistsByIdOrThrow(id);
        studentDao.deleteStudentById(id);
    }

    private void checkIfStudentExistsByIdOrThrow(UUID id) {
        if (!studentDao.checkIfExistsStudentById(id)) {
            throw new RuntimeException();
        }
    }


}
