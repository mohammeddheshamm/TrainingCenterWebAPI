package com.example.TrainingCenter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TrainingCenter.Entity.Instructor;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {

	
}
