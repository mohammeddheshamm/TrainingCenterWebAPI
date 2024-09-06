package com.example.TrainingCenter.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TrainingCenter.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{

}
