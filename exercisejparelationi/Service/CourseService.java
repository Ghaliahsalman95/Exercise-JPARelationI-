package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.API.APIException;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repositry.CourseRepository;
import com.example.exercisejparelationi.Repositry.TeacherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepositry teacherRepositry;

    public void addCourse(Integer teacherId, Course course) {
        if (teacherRepositry.findTeacherById(teacherId) == null) {
            throw new APIException("Teacher not found");
        }
            course.setTeacher(teacherRepositry.findTeacherById(teacherId));
             courseRepository.save(course);

    }

        public List<Course> getAllCourses() {
            return courseRepository.findAll();
        }


        public void updateCourse(Integer id, Course course) {
            if( courseRepository.findById(id)==null) throw new APIException("Course not found");
        else course.setName(course.getName());

            courseRepository.save(course);
        }

        public void deleteCourse(Integer id) {
            if( courseRepository.findById(id)==null){
                throw new APIException("Course not found with id : " + id);}
        else {            Course course=courseRepository.getById(id);

                courseRepository.delete(course);}
        }

        public String getTeacherName(Integer courseId) {
            if( courseRepository.getById(courseId)==null){ throw new APIException("Course not found");}
Course course=courseRepository.getById(courseId);
            Teacher teacher = course.getTeacher();
            if (teacher != null) {
                return teacher.getName();
            } else {
                throw new APIException("Teacher not found for course ");
            }
        }


    }