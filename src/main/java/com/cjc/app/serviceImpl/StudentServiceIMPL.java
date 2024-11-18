package com.cjc.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cjc.app.model.Student;
import com.cjc.app.reposiory.StudentRepository;
import com.cjc.app.service.StudentService;
@Service
public class StudentServiceIMPL implements StudentService{

	private StudentRepository repositroy;

	public StudentServiceIMPL(StudentRepository repositroy) {
		super();
		this.repositroy = repositroy;
	}

	@Override
	public Student saveStudent(Student stu) {
		
		return repositroy.save(stu);
	}

	@Override
	public Student getStudent(int rollno) {
		Optional<Student> optional = repositroy.findById(rollno);
		if(optional.isPresent()) {
			Student student = optional.get();
		     return student;
		}
		return null;
	}
	
	@Override
	public List<Student> getAllStudent() {
		List<Student> list = repositroy.findAll();
		return list;
	}

	@Override
	public List<Student> deleteStudent(int rollno) {
		repositroy.deleteById(rollno);
		return getAllStudent();
	}
	
	@Override
	public Student editStudent(Student stu) {
		Student s=repositroy.save(stu);
		return s;
	}
}
