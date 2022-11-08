package com.Management.Student.Controller;

import com.Management.Student.Entity.Student;
import com.Management.Student.Repository.StudentRepository;
import com.Management.Student.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Controller
public class StudentController {

    private StudentService studentService;
    private StudentRepository studentRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }
    @GetMapping("/student")
    public String listOfStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student";
    }
    @GetMapping("/student/add")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "add-Student";
    }
    @PostMapping("/student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student";
    }
    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable int id, Model model){
        model.addAttribute("student", studentService.findStudentById(id));
        return "edit-Student";
    }
    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable int id,
                                Model model,
                                @ModelAttribute Student student){
        Student oldStudent = studentService.findStudentById(id);
        oldStudent.setId(student.getId());
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        oldStudent.setEmail(student.getEmail());
        studentService.updateStudent(oldStudent);

        return "redirect:/student";
    }
    @GetMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }
}