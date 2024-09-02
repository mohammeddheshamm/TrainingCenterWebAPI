package com.example.TrainingCenter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IGenericRepository<T,K> extends JpaRepository<T, K>{

}
