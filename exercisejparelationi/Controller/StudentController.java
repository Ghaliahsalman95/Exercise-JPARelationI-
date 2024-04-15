package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.API.APIResponse;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Service.CourseService;
import com.example.exercisejparelationi.Service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/get-all")
    public ResponseEntity getAllStudents() {
        logger.info("get all student");
        return ResponseEntity.status(200).body(studentService.getall());
    }


    @PostMapping("add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student) {
        logger.info("Add student");
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new APIResponse("Student Added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student) {
        logger.info("update Student");
        studentService.updateStudent(student, id);
        return ResponseEntity.status(200).body(new APIResponse("Student updated"));

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        logger.info("delete Student");
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new APIResponse("Student deleted"));
    }

    @PutMapping("change-major/{studentID}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer studentID, @PathVariable String major) {
        studentService.changeMajor(studentID, major);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("change successfully"));
    }
}
