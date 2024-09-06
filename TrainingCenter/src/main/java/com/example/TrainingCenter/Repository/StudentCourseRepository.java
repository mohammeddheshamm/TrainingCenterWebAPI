package com.example.TrainingCenter.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TrainingCenter.Entity.StudentCourse;
import com.example.TrainingCenter.Entity.Keys.StudentCourseKey;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseKey> {

}
