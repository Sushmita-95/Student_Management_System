package com.Management.Student;

import com.Management.Student.Entity.Student;
import com.Management.Student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);

	}
}