package com.example.TrainingCenter.Service;

import java.util.List;

public interface IGenericEntityService<T> extends IGenericService<T> {

	List<T> getAllElements();
	
	T getElementById(Long id);
}
