package com.example.TrainingCenter.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainingCenter.Entity.Course;
import com.example.TrainingCenter.Exception.EntityAlreadyExistsException;
import com.example.TrainingCenter.Exception.NoEntitiesYetException;
import com.example.TrainingCenter.Exception.NoSuchEntityException;
import com.example.TrainingCenter.Repository.CourseRepository;
@Service
public class CourseServiceImpl implements IGenericEntityService<Course>{

	@Autowired
	CourseRepository courseRepo;
	
	@Override
	public List<Course> getAllElements() {
		
		List<Course> courses = courseRepo.findAll();
		if(courses == null) {
			throw new NoEntitiesYetException("There is no courses yet.");
		}
		return courses;
	}

	@Override
	public Course getElementById(Long id) {
		return courseRepo.findById(id).orElseThrow(
				() -> new NoSuchElementException("No Course by this ID "+id));
	}

	@Override
	public String addElement(Course element) {
		Course crs = courseRepo.findById(element.getId()).orElse(null);
		if(crs == null) {
			courseRepo.save(element);
			return "Course Added Successfully";
		}
		else {
			throw new EntityAlreadyExistsException("This course already exists");
		}
	}

	@Override
	public String updateElement(Course element) {
		Course crs = courseRepo.findById(element.getId()).orElse(null);
		if(crs == null) {
			throw new NoSuchEntityException("course is not found");
		}
		else {
			crs.setDesc(element.getDesc());
			crs.setDurationInMonths(element.getDurationInMonths());
			crs.setName(element.getName());
			crs.setStartDate(element.getStartDate());
			crs.setCost(element.getCost());
			courseRepo.save(crs);
			return "Course Updated Successfuly";
		}
	}

	@Override
	public String deleteElement(Course element) {
		
		Course crs = courseRepo.findById(element.getId()).orElse(null);
		if(crs == null) {
			throw new NoSuchEntityException("course is not found");
		}
		else {
			courseRepo.delete(crs);
			return "Course Deleted Successfully";
		}
		
	}

	

}
