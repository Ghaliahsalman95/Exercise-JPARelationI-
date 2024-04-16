package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.API.APIException;
import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Repositry.StudentRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepositry studentRepositry;

    public List<Student> getall() {
        return studentRepositry.findAll();
    }

    public void addStudent(Student student) {
        studentRepositry.save(student);
    }

    public void updateStudent(Student student, Integer id) {
        Student student1 = studentRepositry.findStudentById(id);
        if (student1 == null) {
            throw new APIException("Not found Student");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
       // student1.setCourses(student.getCourses());
        studentRepositry.save(student1);

    }

    public void deleteStudent(Integer id) {
        Student student1 = studentRepositry.findStudentById(id);
        if (student1 == null) {
            throw new APIException("Not found Student");
        }
        studentRepositry.delete(student1);
    }
public void changeMajor(Integer studentID, String major){
      Student student=studentRepositry.findStudentById(studentID);
      if(student!=null){
          if(!student.getMajor().equalsIgnoreCase(major)){
          student.setMajor(major);
          student.getCourses().clear();
          student.setCourses(null);
          studentRepositry.save(student);}
          else{throw new APIException("can not change with same major ");}
      }
      else {throw new APIException("Not found student with id "+studentID);}

}



}
