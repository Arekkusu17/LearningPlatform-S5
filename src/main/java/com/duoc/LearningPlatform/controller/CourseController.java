package com.duoc.LearningPlatform.controller;

import com.duoc.LearningPlatform.model.Course;
import com.duoc.LearningPlatform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public List<Course> getAllCourses(@RequestParam(name = "sorted", defaultValue = "false") boolean sorted) {
        if (sorted) {
            return courseService.getSortedCourses();
        }
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        return ResponseEntity.ofNullable(courseService.getCourseById(id));
    }

    @PostMapping("/course")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @PutMapping("/course/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody Course course) {
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}