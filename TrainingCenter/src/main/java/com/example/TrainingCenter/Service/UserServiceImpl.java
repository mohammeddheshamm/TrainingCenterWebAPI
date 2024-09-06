package com.example.TrainingCenter.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainingCenter.Entity.User;
import com.example.TrainingCenter.Exception.EntityAlreadyExistsException;
import com.example.TrainingCenter.Exception.NoSuchEntityException;
import com.example.TrainingCenter.Repository.UserRepository;

@Service
public class UserServiceImpl implements IGenericEntityService<User>{

	@Autowired
	UserRepository repo;
	
	@Override
	public List<User> getAllElements() {
		return repo.findAll();
	}

	@Override
	public User getElementById(Long id) {
		return repo.findById(id).orElseThrow(
				() -> new NoSuchElementException("No User by this ID : "+id));
	}

	@Override
	public String addElement(User element) {
		User usr = repo.findById(element.getUserId()).orElse(null);
		if(usr == null){
			repo.save(element);
			return "User saved successfully";
		}else {
			throw new EntityAlreadyExistsException("This user already exists");
		}
		
	}

	@Override
	public String updateElement(User element) {
		User usr = repo.findById(element.getUserId()).orElse(null);
		if(usr == null){
			throw new NoSuchEntityException("This user is not found");
		}
		else {
			usr.setEmail(element.getEmail());
			usr.setPassword(element.getPassword());
			usr.setPhoneNumber(element.getPhoneNumber());
			usr.setUserName(element.getUserName());
			repo.save(usr);
			return "User Updated successfully";
		}
	}

	@Override
	public String deleteElement(User element) {
		User usr = repo.findById(element.getUserId()).orElse(null);
		if(usr == null){
			throw new NoSuchEntityException("This user is not found");
		}
		else {
			repo.delete(usr);
			return "User deleted Successfully";
		}
	}

}
