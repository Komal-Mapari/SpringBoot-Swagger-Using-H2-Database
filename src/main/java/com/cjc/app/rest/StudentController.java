package com.cjc.app.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.model.Student;
import com.cjc.app.model.Students;
import com.cjc.app.service.StudentService;

@RestController
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@PostMapping(value = "/saveStudent",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	public ResponseEntity<Student> saveStudent(@RequestBody Student stu){
		Student s=service.saveStudent(stu);

		return new ResponseEntity<Student>(s,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getStudent/{rollno}",
			produces = {"application/json","application/xml"})
	public ResponseEntity<Student> getStudent(@PathVariable int rollno){
		Student s= service.getStudent(rollno);
		if(s!=null) {
			return new ResponseEntity<Student>(s,HttpStatus.OK);
		}
		
		return new ResponseEntity<Student>(s,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/getAllStudent",
			produces = {"application/json","application/xml"})
	public ResponseEntity<Students> getAllStudent() {
		List<Student> stulist=service.getAllStudent();
		
		Students students= new Students();
		students.setStulist(stulist);
		
		return new ResponseEntity<Students>(students,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteStudent/{rollno}",
			produces = {"application/json","application/xml"})
	public ResponseEntity<Students> deleteStuEntity(@PathVariable int rollno) {
		List<Student> stulist= service.deleteStudent(rollno);
		
		Students students=new Students();
		students.setStulist(stulist);
		
		return new ResponseEntity<Students>(students,HttpStatus.OK);
	}
	
	@PutMapping(value = "/editStudent",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	public ResponseEntity<Student> editStudent(@RequestBody Student stu) {
		Student s=service.editStudent(stu);
		
		return new ResponseEntity<Student>(s,HttpStatus.OK);
	}
	

}
