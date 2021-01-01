package com.ey.hr.lms.code.Controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ey.hr.lms.code.Entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	@Query(nativeQuery = true, value="SELECT * FROM public.student where lower(location_student) like %?1%")
	List<Student> fuzzyLocationStudent(String locationString);
	
}
