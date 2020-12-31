package com.ey.hr.lms.code.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ey.hr.lms.code.Entities.Student;

@RestController
public class StudentController {

	@Autowired
	StudentRepo studentRepoObj;

	@RequestMapping("/students")
	public List<Student> giveAllStudent() {
		return studentRepoObj.findAll();
	}

	@RequestMapping("/students/{id}")
	public Student giveAllStudent(@PathVariable long id) {
		Optional<Student> studentRecord = studentRepoObj.findById(id);

		if (!studentRecord.isPresent()) {
			return new Student();
		}

		return studentRecord.get();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addNewStudent")
	public Student addNewStudent(@RequestBody Student studentObj) {
		Student studentReturn = studentRepoObj.save(studentObj);
		return studentReturn;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateStudent/{id}")
	public Student updateStudent(@RequestBody Student studentObj, @PathVariable long id) {
		Optional<Student> studentRecord = studentRepoObj.findById(id);

		if (!studentRecord.isPresent()) {
			return new Student();
		}
		
		return studentRepoObj.save(studentObj);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteStudent/{id}")
	public Student Student(@PathVariable long id) {
		Optional<Student> studentRecord = studentRepoObj.findById(id);

		if (!studentRecord.isPresent()) {
			return new Student();
		}
		
		studentRepoObj.deleteById(id);
		
		return studentRecord.get();
	}

}
