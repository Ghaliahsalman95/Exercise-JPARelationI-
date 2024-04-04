package com.example.exercisejparelationi.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course addCourse(Integer teacherId, Course course) {
    if(teacherRepository.findById(teacherId)==null){
                throw new APIException("Teacher not found"));
       
        course.setTeacher(teacherRepository.findById(teacherId));
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    public void updateCourse(Integer id, Course course) {
    if( courseRepository.findById(id)==null) throw new APIException("Course not found"));
        else course.setName(course.getName());
  
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
       if( courseRepository.findById(id)==null)
throw new APIException("Course not found with id : " + id));
        else courseRepository.delete(course);
    }
    
    public String getTeacherName(Integer courseId) {
  if( courseRepository.findById(courseId)==null){ throw new APIException("Course not found"));}
        
        Teacher teacher = course.getTeacher();
        if (teacher != null) {
            return teacher.getName();
        } else {
            throw new APIException("Teacher not found for course ");
        }
    }

    
}
