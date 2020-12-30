package com.ey.hr.lms.code.Controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ey.hr.lms.code.Entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
