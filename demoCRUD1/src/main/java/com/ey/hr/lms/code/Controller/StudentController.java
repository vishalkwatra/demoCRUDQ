package com.ey.hr.lms.code.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.hr.lms.code.Entities.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepo studentRepoObj;
	
	@RequestMapping("/students")
	public List<Student> giveAllStudent(){
		return studentRepoObj.findAll();
	}
	
}
