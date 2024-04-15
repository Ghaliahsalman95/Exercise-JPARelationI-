package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.API.APIResponse;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Service.CourseService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping("/get-all")
    public ResponseEntity getAllCourses() {
        logger.info("get all courses");

        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }


    @PostMapping("add/{teacherId}")
    public ResponseEntity addCourse(@PathVariable Integer teacherId, @RequestBody @Valid Course course) {
        logger.info("Add course");
        courseService.addCourse(teacherId, course);
        return ResponseEntity.status(200).body(new APIResponse("Added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course) {
        logger.info("update course");
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new APIResponse("update"));

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        logger.info("delete course");
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new APIResponse("delete"));
    }

    @GetMapping("get-teacher-name/{id}")
    public ResponseEntity getTeacherNameByCourseId(@PathVariable Integer id) {
        logger.info("teacher name");

        return ResponseEntity.status(200).body(courseService.getTeacherName(id));
    }

    @GetMapping("get-list-students/{courseID}")
    public ResponseEntity getListStudent(@PathVariable Integer courseID){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getListStudent(courseID));
    }
@PutMapping("add-student-to-course/{studentID}/{courseID}")
    public ResponseEntity addStudentsTocourse(@PathVariable Integer studentID, @PathVariable Integer courseID){
        courseService.addStudentsTocourse(courseID,studentID);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Student ID"+studentID +"Added course ID"+courseID+"successfully"));
    }
//}

}