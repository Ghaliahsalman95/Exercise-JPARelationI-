package com.example.exercisejparelationi.Repositry;

import com.example.exercisejparelationi.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
Course getById(Integer id);
}