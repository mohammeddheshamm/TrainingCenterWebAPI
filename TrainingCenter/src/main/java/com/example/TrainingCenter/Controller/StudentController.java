package com.example.TrainingCenter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainingCenter.Entity.Course;
import com.example.TrainingCenter.Entity.Student;
import com.example.TrainingCenter.Entity.Dtos.CourseGradeDto;
import com.example.TrainingCenter.Entity.Keys.StudentCourseKey;
import com.example.TrainingCenter.Service.StudentCourseServiceImpl;
import com.example.TrainingCenter.Service.StudentServiceImpl;

@EnableMethodSecurity
@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	StudentServiceImpl std;
	
	@Autowired
	StudentCourseServiceImpl stdCrs;
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('INSTRUCTOR')")
	@GetMapping(value = "/getAll", 
			produces = "application/json")
	public List<Student> getAll(){
		return std.getAllElements();
	}
	
	@PreAuthorize("hasAuthority('STUDENT') or hasAuthority('ADMIN') or hasAuthority('INSTRUCTOR')")
	@GetMapping("/getStudentById/{id}")
	public Student findStudent(@PathVariable Long id) {
		return std.getElementById(id);
	}
	
	@PreAuthorize("hasAuthority('STUDENT') or hasAuthority('ADMIN') or hasAuthority('INSTRUCTOR')")
	@PostMapping(value = "/addStudent",
			consumes = "application/json",
			produces = "application/json")
	public String addStudent(@RequestBody Student student) {
		return std.addElement(student);
	}
	
	
	@PreAuthorize("hasAuthority('STUDENT') or hasAuthority('ADMIN')")
	@PutMapping(value = "/updateStudent",
			consumes = "application/json",
			produces = "application/json")
	public String updateStudent(@RequestBody Student student) {
		return std.updateElement(student);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('INSTRUCTOR')")
	@DeleteMapping("/deleteStudent")
	public String deleteStudent(@RequestBody Student student) {
		return std.deleteElement(student);
	}
	
	@PreAuthorize("hasAuthority('STUDENT') or hasAuthority('ADMIN') or hasAuthority('INSTRUCTOR')")
	@GetMapping("/getRegisteredCourses/{id}")
	public List<Course> getAllCoursesRegisteredByStudentId(@PathVariable Long stdId){
		return stdCrs.getAllCoursesRegisteredByStudentId(stdId);
	}
	
	
	@PreAuthorize("hasAuthority('STUDENT') or hasAuthority('ADMIN') or hasAuthority('INSTRUCTOR')")
	@GetMapping(value = "/getCourseGrade/{stdId}/crsId",
			produces = "application/json")
	public CourseGradeDto getCourseWithGrade(@PathVariable Long stdId,Long crsId) {
		StudentCourseKey key = new StudentCourseKey(stdId,crsId);
		return stdCrs.getCourseWithGradeByStudentCourseId(key);
	}
}
