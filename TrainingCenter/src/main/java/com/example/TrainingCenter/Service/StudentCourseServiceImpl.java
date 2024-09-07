package com.example.TrainingCenter.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainingCenter.Entity.Course;
import com.example.TrainingCenter.Entity.Student;
import com.example.TrainingCenter.Entity.StudentCourse;
import com.example.TrainingCenter.Entity.Dtos.CourseGradeDto;
import com.example.TrainingCenter.Entity.Keys.StudentCourseKey;
import com.example.TrainingCenter.Exception.EntityAlreadyExistsException;
import com.example.TrainingCenter.Exception.NoCoursesAssignedToThisStudent;
import com.example.TrainingCenter.Exception.NoStudentsRegisteredThisCourse;
import com.example.TrainingCenter.Exception.NoSuchEntityException;
import com.example.TrainingCenter.Repository.CourseRepository;
import com.example.TrainingCenter.Repository.StudentCourseRepository;
import com.example.TrainingCenter.Repository.StudentRepository;

@Service
public class StudentCourseServiceImpl implements IGenericService<StudentCourse>{

	@Autowired
	StudentCourseRepository repo;
	
	@Autowired
	CourseRepository crsRepo;
	
	@Autowired
	StudentRepository stdRepo;
	
	public CourseGradeDto getCourseWithGradeByStudentCourseId(StudentCourseKey id) {
	
		Student std = stdRepo.findById(id.getStudentId()).orElse(null);
		Course crs = crsRepo.findById(id.getCourseId()).orElse(null);
		
		if(std == null) {
			throw new NoSuchElementException("There is no student by this ID : "+id.getStudentId());
		} else if(crs == null) {
			throw new NoSuchElementException("There is no course by this ID : "+ id.getCourseId()+" Registed by this student");
		}
		else {
			List<StudentCourse> list = repo.findAll();
		
			for(StudentCourse stdCrs : list) {
				if(stdCrs.getId().getCourseId() == id.getCourseId()
						&& stdCrs.getId().getStudentId() == id.getStudentId()) {
					CourseGradeDto dto = new CourseGradeDto();
					Course course = crsRepo.findById(stdCrs.getId().getCourseId()).orElse(null);
					dto.setCourse(course);
					dto.setGrade(stdCrs.getGrade());
					return dto;
				}
			}
			throw new NoCoursesAssignedToThisStudent("This student didn't register any course yet");
		}
	}
	
	public List<Course> getAllCoursesRegisteredByStudentId(Long stdId){
		
		Student std = stdRepo.findById(stdId).orElse(null);
		if(std == null) {
			throw new NoSuchElementException("There is no student by this ID : "+stdId);
		}
		else {
		List<StudentCourse> list = repo.findAll();
		List<Course> courses = null;
			for(StudentCourse stdCrs : list) {
				if(stdCrs.getId().getStudentId().equals(stdId)) {
					courses = new ArrayList<Course>();
					courses.add(crsRepo.findById(stdCrs.getId().getCourseId()).orElse(null));
				}
			}
			if(courses == null) {
				throw new NoCoursesAssignedToThisStudent("This student didn't register any course yet");
			}
			else {
				return courses;
			}
		}
	}

	public List<Student> getAllStudentsRegisteredCourseById(Long crsId){
		Course crs = crsRepo.findById(crsId).orElse(null);
		if(crs == null) {
			throw new NoSuchElementException("There is no course by this ID : "+ crsId);
		}
		else {
		List<StudentCourse> list = repo.findAll();
		List<Student> students = null;
			for(StudentCourse stdCrs : list) {
				if(stdCrs.getId().getCourseId().equals(crsId)) {
					students = new ArrayList<Student>();
					students.add(stdRepo.findById(stdCrs.getId().getStudentId()).orElse(null));
				}
			}
			if(students == null) {
				throw new NoStudentsRegisteredThisCourse("No One Registered this Course");
			}else {
				return students;
			}
		}
		
	}
	
	@Override
	public String addElement(StudentCourse element) {
		List<StudentCourse> list = repo.findAll();
		for(StudentCourse x : list) {
			if(x.getId().equals(element.getId())) {
				throw new EntityAlreadyExistsException("This Element already exists.");
			}
		}
		repo.save(element);
		return "StudentCourse Added Successfully";
	}

	@Override
	public String updateElement(StudentCourse element) {
		
		List<StudentCourse> list = repo.findAll();
		for(StudentCourse x : list) {
			if(x.getId().equals(element.getId())) {
				x.setGrade(element.getGrade());
				repo.save(x);
				return "StudentCourse Updated Successfully";
			}
		}
		
		throw new NoSuchEntityException("This Element is not found");
	}

	@Override
	public String deleteElement(StudentCourse element) {
		List<StudentCourse> list = repo.findAll();
		for(StudentCourse x : list) {
			if(x.getId().equals(element.getId())) {
				repo.delete(element);
				return "StudentCourse Deleted Successfully";
			}
		}
		
		throw new NoSuchEntityException("This Element is not found");
	}
	
	public String courseRegisterationByCourseId(Long Id) {
		return null;
	}

}
