package com.example.exercisejparelationi.Repositry;

import com.example.exercisejparelationi.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositry extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);


}
