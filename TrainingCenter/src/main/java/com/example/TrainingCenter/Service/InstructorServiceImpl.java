package com.example.TrainingCenter.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainingCenter.Entity.Instructor;
import com.example.TrainingCenter.Exception.EntityAlreadyExistsException;
import com.example.TrainingCenter.Exception.NoEntitiesYetException;
import com.example.TrainingCenter.Exception.NoSuchEntityException;
import com.example.TrainingCenter.Repository.InstructorRepository;
@Service
public class InstructorServiceImpl implements IGenericEntityService<Instructor> {

	@Autowired
	InstructorRepository repo;
	
	@Override
	public List<Instructor> getAllElements() {
		List<Instructor> instructors = repo.findAll();
		if(instructors == null) {
			throw new NoEntitiesYetException("There is instructors added yet");
		}
		return instructors;
	}

	@Override
	public Instructor getElementById(Long id) {
		return repo.findById(id).orElseThrow(
				() -> new NoSuchElementException("There is no instructor by this ID : "+id));
	}

	@Override
	public String addElement(Instructor element) {
		Instructor ins = repo.findById(element.getId()).orElse(null);
		if(ins == null) {
			repo.save(element);
			return "Instructor Added Successfully";
		}
		else {
			throw new EntityAlreadyExistsException("This Instructor already exists");
		}
	}

	@Override
	public String updateElement(Instructor element) {
		Instructor ins = repo.findById(element.getId()).orElse(null);
		if(ins == null) {
			throw new NoSuchEntityException("This Instructor does not exist");
		}
		else {
			ins.setAddress(element.getAddress());
			ins.setBouns(element.getBouns());
			ins.setHireDate(element.getHireDate());
			ins.setName(element.getName());
			ins.setSalary(element.getSalary());
			repo.save(ins);
			return "Instructor Updated Successfully";
		}
	}

	@Override
	public String deleteElement(Instructor element) {
		Instructor ins = repo.findById(element.getId()).orElse(null);
		if(ins == null) {
			throw new NoSuchEntityException("This Instructor does not exist");
		}
		else {
			repo.delete(ins);
			return "Instructor Deleted Successfully";
		}
	}

}
