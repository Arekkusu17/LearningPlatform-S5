package com.duoc.LearningPlatform.service;

import com.duoc.LearningPlatform.model.Course;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final List<Course> courses = new ArrayList<>(
        Arrays.asList(
            new Course(1, "Java Backend", "Programación"),
            new Course(2, "Bases de Datos", "Sistemas"),
            new Course(3, "Arquitectura de Microservicios", "Programación")
        )
    );

    public List<Course> getAllCourses() {
        // Devuelve una lista inmutable para evitar modificaciones externas
        return Collections.unmodifiableList(new ArrayList<>(courses));
    }

    public Course getCourseById(int id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(int id, Course updatedCourse) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.set(i, updatedCourse);
                return;
            }
        }
    }

    public void deleteCourse(int id) {
        courses.removeIf(course -> course.getId() == id);
    }

    public List<Course> getSortedCourses() {
        // Lógica personalizada para ordenar los cursos por nombre alfabeticamente
        return courses.stream()
                .sorted(Comparator.comparing(Course::getName))
                .collect(Collectors.toList());
    }
}