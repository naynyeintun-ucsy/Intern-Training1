package com.intern.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intern.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	
	List<Student> findByStudentNameOrStudentPhoneNo(String studentName,String studentPhone);
	
	
	@Query (value = "Select s from Student s where s.studentName like concat('%',concat(?1,'%'))"
			+ "and s.studentPhoneNo like concat('%',concat(?2,'%'))")
	List<Student> searchStudent(String name,String phone);
	
	
	@Query(value="select * from student where student_name like  concat('%',?1,'%')" 
			, nativeQuery =  true)
	List<Student> searchWithNativeQuery(String name);
	

}
