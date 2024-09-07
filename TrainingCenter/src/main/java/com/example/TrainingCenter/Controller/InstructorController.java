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
import com.example.TrainingCenter.Entity.Instructor;
import com.example.TrainingCenter.Service.InstructorCourseServiceImpl;
import com.example.TrainingCenter.Service.InstructorServiceImpl;


@RequestMapping(value = "/instructor")
@RestController
public class InstructorController {

	@Autowired
	InstructorServiceImpl ins;
	
	@Autowired
	InstructorCourseServiceImpl insCrs;
	
	@GetMapping(value = "/getAllInstructors"
			, produces = "application/json")
	public List<Instructor>  getAllInstructors(){
		return ins.getAllElements();
	}
	
	@GetMapping(value = "/getInstructorById/{id}" 
			,produces = "application/json")
	public Instructor getInstructorById(@PathVariable Long id) {
		return ins.getElementById(id);
	}
	
	@PostMapping(value = "/addInstructor" 
			, consumes = "application/json")
	public String addInstructor(@RequestBody Instructor instructor) {
		return ins.addElement(instructor);
	}
	
	@PutMapping(value = "/updateInstructor" ,
			consumes = "application/json")
	public String updateInstructor(@RequestBody Instructor instructor) {
		return ins.updateElement(instructor);
	}
	
	@DeleteMapping(value = "/deleteInstructor" ,
			consumes = "application/json")
	public String deleteInstructor(@RequestBody Instructor instructor) {
		return ins.deleteElement(instructor);
	}
	
	@GetMapping(value = "/getCoursesTeachedByInsId/{id}")
	public List<Course> getCoursesTeachedByInsId(@PathVariable Long id){
		return insCrs.getAllCoursesTeachedByInsByInstructorId(id);
	}
	
}
