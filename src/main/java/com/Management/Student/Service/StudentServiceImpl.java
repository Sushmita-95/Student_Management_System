package com.Management.Student.Service;

import com.Management.Student.Entity.Student;
import com.Management.Student.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void updateStudent(Student oldStudent) {
        studentRepository.save(oldStudent);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
