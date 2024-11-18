package com.cjc.app.service;

import java.util.List;

import com.cjc.app.model.Student;

public interface StudentService {

	Student saveStudent(Student stu);

	Student getStudent(int rollno);

	List<Student> getAllStudent();

	List<Student> deleteStudent(int rollno);

	Student editStudent(Student stu);

	

}
