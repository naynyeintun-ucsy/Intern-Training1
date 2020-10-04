package com.intern.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.student.entity.Student;
import com.intern.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> findAll(){
		List<Student> studentList= studentRepository.findAll();
		return studentList;
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public void deleteStudentById(Long  id) {
		studentRepository.deleteById(id);
	}
	
	public List<Student> studentSearch(String name,String phone){
		return studentRepository.searchStudent(name, phone);
	}

}
