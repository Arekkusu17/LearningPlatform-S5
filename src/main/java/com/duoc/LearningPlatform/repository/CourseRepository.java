//WILL BE IMPLEMENTED IN THE FUTURE 
package com.duoc.LearningPlatform.repository;

import com.duoc.LearningPlatform.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}