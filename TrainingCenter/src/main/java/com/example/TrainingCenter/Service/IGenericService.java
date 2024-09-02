package com.example.TrainingCenter.Service;

public interface IGenericService<T> {

	String addElement(T element);
	
	String updateElement (T element);
	
	String deleteElement(T element);
	
}
