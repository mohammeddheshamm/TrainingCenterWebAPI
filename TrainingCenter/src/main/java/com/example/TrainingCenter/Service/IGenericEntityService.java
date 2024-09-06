package com.example.TrainingCenter.Service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IGenericEntityService<T> extends IGenericService<T> {

	List<T> getAllElements();
	
	T getElementById(Long id);
}
