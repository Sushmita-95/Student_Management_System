package com.Management.Student.Service;

import com.Management.Student.Entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student findStudentById(int id);

    void updateStudent(Student oldStudent);

     void deleteStudentById(int id);
}
