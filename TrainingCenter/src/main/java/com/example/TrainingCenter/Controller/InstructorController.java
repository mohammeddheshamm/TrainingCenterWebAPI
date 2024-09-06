package com.example.TrainingCenter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainingCenter.Entity.Instructor;
import com.example.TrainingCenter.Service.InstructorServiceImpl;


@RequestMapping(value = "/instructor")
@RestController
public class InstructorController {

	@Autowired
	InstructorServiceImpl ins;
	
	@GetMapping(value = "/getAllInstructors" , consumes = "application/json")
	public List<Instructor>  getAllInstructors(){
		return ins.getAllElements();
	}
	
	
}
