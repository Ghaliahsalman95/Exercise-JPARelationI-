package com.example.exercisejparelationi.Repositry;

import com.example.exercisejparelationi.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositry extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
}
