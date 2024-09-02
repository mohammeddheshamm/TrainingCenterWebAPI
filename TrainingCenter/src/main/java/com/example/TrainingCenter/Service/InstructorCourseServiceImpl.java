package com.example.TrainingCenter.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.TrainingCenter.Entity.Course;
import com.example.TrainingCenter.Entity.Instructor;
import com.example.TrainingCenter.Entity.InstructorCourse;
import com.example.TrainingCenter.Entity.Dtos.InstructorCourseEvaluationDto;
import com.example.TrainingCenter.Entity.Keys.InstructorCourseKey;
import com.example.TrainingCenter.Exception.EntityAlreadyExistsException;
import com.example.TrainingCenter.Exception.NoCoursesTeachedByInstructor;
import com.example.TrainingCenter.Exception.NoInstructorTeachCourseException;
import com.example.TrainingCenter.Exception.NoSuchEntityException;
import com.example.TrainingCenter.Repository.CourseRepository;
import com.example.TrainingCenter.Repository.InstructorCourseRepository;
import com.example.TrainingCenter.Repository.InstructorRepository;

public class InstructorCourseServiceImpl implements IGenericService<InstructorCourse> {
	
	@Autowired
	InstructorCourseRepository repo;
	
	@Autowired
	InstructorRepository insRepo;
	
	@Autowired
	CourseRepository crsRepo;
	
	@Override
	public String addElement(InstructorCourse element) {
		List<InstructorCourse> list = repo.findAll();
		for(InstructorCourse insCrs : list) {
			if(insCrs.getId().equals(element.getId())) {
				throw new EntityAlreadyExistsException("This element already exists");
			}
		}
		repo.save(element);
		return "InstructorCourse Added Successfullys";
	}
	
	@Override
	public String updateElement(InstructorCourse element) {
		
		List<InstructorCourse> list = repo.findAll();
		for(InstructorCourse insCrs : list) {
			if(insCrs.getId().equals(element.getId())) {
				insCrs.setEvaluation(element.getEvaluation());
				repo.save(insCrs);
				return "InstructorCourse Updated Successfully";
			}
		}
		
		throw new NoSuchEntityException("This Element isn't found");
	}
	
	@Override
	public String deleteElement(InstructorCourse element) {
		List<InstructorCourse> list = repo.findAll();
		for(InstructorCourse insCrs : list) {
			if(insCrs.getId().equals(element.getId())) {
				repo.delete(element);
				return "InstructorCourse deleted successfully";
			}
		}
		
		throw new NoSuchEntityException("This element is not found");
	}
	
	public List<Course> getAllCoursesTeachedByInsByInstructorId(Long insId){
		Instructor ins = insRepo.findById(insId).orElse(null);
		if(ins == null) {
			throw new NoSuchElementException("There is no Instructor by this ID : " + insId);
		}
		else {
			List<InstructorCourse> list = repo.findAll();
			List<Course> courses = null;
			for(InstructorCourse insCrs : list) {
				if(insCrs.getId().getInstructorId().equals(insId)) {
					courses = new ArrayList<Course>();
					courses.add(crsRepo.findById(insCrs.getId().getCourseId()).orElse(null));
				}
			}
			if(courses == null) {
				throw new NoCoursesTeachedByInstructor("There is no courses teached by instructor by this Id : "+ insId);
			}else {
				return courses;
			}
		}
	}
	
	public List<Instructor> getAllInstructorsTeachCourseByCourseId(Long crsId){
		Course crs = crsRepo.findById(crsId).orElse(null);
		if(crs == null) {
			throw new NoSuchEntityException("There is no Course by this Id : "+crsId);
		}
		else {
			List<InstructorCourse> list = repo.findAll();
			List<Instructor> instructors = null;
			for(InstructorCourse insCrs : list) {
				if(insCrs.getId().getCourseId().equals(crsId)) {
					instructors = new ArrayList<Instructor>();
					instructors.add(insRepo.findById(insCrs.getId().getInstructorId()).orElse(null));
				}
			}
			if(instructors == null) {
				throw new NoInstructorTeachCourseException("There is no Instructors Teached course by Id : "+ crsId);
			}
			else {
				return instructors;
			}
		}
	}
	
	public InstructorCourseEvaluationDto getInstructorCourseWithEvaluationByInstructorCourseId(InstructorCourseKey id) {
		Instructor ins = insRepo.findById(id.getInstructorId()).orElse(null);
		Course crs = crsRepo.findById(id.getCourseId()).orElse(null);
		
		if(ins == null) {
			throw new NoSuchElementException("There is no Instructor by this Id : " + id.getInstructorId());
		}else if(crs == null) {
			throw new NoSuchElementException("There is no course by this Id : "+id.getCourseId()+" asssigned to instructor by Id : "+id.getInstructorId());
		}else {
			List<InstructorCourse> list = repo.findAll();
			
			for(InstructorCourse insCrs : list) {
				if(insCrs.getId().getCourseId().equals(id.getCourseId())
						&& insCrs.getId().getInstructorId().equals(id.getInstructorId())) {
					InstructorCourseEvaluationDto dto = new InstructorCourseEvaluationDto();
					Instructor instructor = insRepo.findById(id.getInstructorId()).orElse(null);
					Course course = crsRepo.findById(id.getCourseId()).orElse(null);
					dto.setCourse(course);
					dto.setInstructor(instructor);
					dto.setEvaluation(insCrs.getEvaluation());
					
					return dto;
				}
			}
			throw new NoInstructorTeachCourseException("This instructor "+id.getInstructorId()+" didn't teach this course "+id.getCourseId());
		}
		
	}
}
