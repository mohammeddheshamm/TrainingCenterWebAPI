package com.example.TrainingCenter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainingCenter.Entity.Course;
import com.example.TrainingCenter.Entity.Dtos.InstructorCourseEvaluationDto;
import com.example.TrainingCenter.Entity.Keys.InstructorCourseKey;
import com.example.TrainingCenter.Service.CourseServiceImpl;
import com.example.TrainingCenter.Service.InstructorCourseServiceImpl;

@RequestMapping(value = "/course")
@RestController
public class CourseController {

	@Autowired
	CourseServiceImpl crs;
	
	@Autowired
	InstructorCourseServiceImpl insCrs;
	
	@GetMapping(value = "/getAllCourses",
			produces = "application/json")
	public List<Course> getAllCourses (){
		return crs.getAllElements();
	}
	
	@GetMapping(value = "/getCourseById/{id}"
			,produces = "application/json")
	public Course getCourseById(@PathVariable Long id) {
		return crs.getElementById(id);
	}
	
	@PostMapping(value = "/addCourse"
			,consumes = "application/json")
	public String addCourse(@RequestBody Course course){
		return crs.addElement(course);
	}
	
	@PutMapping(value = "/updateCourse"
			,consumes = "application/json")
	public String updateCourse(@RequestBody Course course) {
		return crs.updateElement(course);
	}
	
	@DeleteMapping(value = "/deleteCourse"
			,consumes = "application/json")
	public String deleteCourse(@RequestBody Course course) {
		return crs.deleteElement(course);
	}
	
	@GetMapping(value ="/getCourseInstructorEvaluationByInsCrsId"
			,produces = "application/json"
			,consumes = "application/json")
	public InstructorCourseEvaluationDto getCourseInstructorEvaluationByInsCrsId(@RequestBody InstructorCourseKey id) {
		return insCrs.getInstructorCourseWithEvaluationByInstructorCourseId(id);
	}
	
}
