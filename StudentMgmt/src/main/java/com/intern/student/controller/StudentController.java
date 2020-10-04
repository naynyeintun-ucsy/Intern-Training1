package com.intern.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intern.student.entity.Student;
import com.intern.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping(value = "/students")
	public List<Student> getAllStudent(){
		List<Student> studentList = studentService.findAll();
		return studentList;
	}
	
	@PostMapping (value = "/student")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping (value = "/student/{id}")
	public Student getStudentById(@PathVariable Long id)
	{
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping (value = "/student/{id}")
	public void deleteStudentById(@PathVariable Long id){
		studentService.deleteStudentById(id);
	}
	
	@GetMapping (value = "/student/search")
	public List<Student> findByStudentName(@RequestParam String studentName,@RequestParam String phone)
	{
		return studentService.studentSearch(studentName, phone);	
	}
    	
	
	

}
