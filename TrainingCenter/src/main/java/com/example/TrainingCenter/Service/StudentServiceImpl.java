package com.example.TrainingCenter.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.TrainingCenter.Entity.Student;
import com.example.TrainingCenter.Exception.EntityAlreadyExistsException;
import com.example.TrainingCenter.Exception.NoSuchEntityException;
import com.example.TrainingCenter.Repository.StudentRepository;

public class StudentServiceImpl implements IGenericEntityService<Student> {

	@Autowired
	StudentRepository studentRepo;
	
	@Override
	public Student getElementById(Long id) {
		return studentRepo.findById(id).orElseThrow(
				() -> new NoSuchElementException("No Student by thsi id "+id+" found."));
	}

	@Override
	public String addElement(Student element) {
		Student exists = studentRepo.findById(element.getId()).orElse(null);
		if(exists == null){
			studentRepo.save((Student)element);
			return "Student Saved Successfully";
		}
		else {
			throw new EntityAlreadyExistsException("This student already exists.");
		}
	}

	@Override
	public String updateElement(Student element) {
		Student exists = studentRepo.findById(element.getId()).orElse(null);
		if(exists == null) {
			throw new NoSuchEntityException("This student is not found.");
		}
		else {
			exists.setFirstName(element.getFirstName());
			exists.setLastName(element.getLastName());
			exists.setAddress(element.getAddress());
			studentRepo.save(exists);
			return "Student updated successfully";
		}
	}

	@Override
	public String deleteElement(Student element) {
		
		Student exists = studentRepo.findById(element.getId()).orElse(null);
		if(exists == null) {
			throw new NoSuchEntityException("This student is not found.");
		}
		else {
			studentRepo.delete(exists);
			return "Student Deleted successfully";
		}
	}

	@Override
	public List<Student> getAllElements() {
		return studentRepo.findAll();
	}
	
	

}
