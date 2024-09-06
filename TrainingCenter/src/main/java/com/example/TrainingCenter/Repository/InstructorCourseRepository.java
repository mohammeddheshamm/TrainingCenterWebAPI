package com.example.TrainingCenter.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TrainingCenter.Entity.InstructorCourse;
import com.example.TrainingCenter.Entity.Keys.InstructorCourseKey;
@Repository
public interface InstructorCourseRepository extends JpaRepository<InstructorCourse, InstructorCourseKey> {

}
