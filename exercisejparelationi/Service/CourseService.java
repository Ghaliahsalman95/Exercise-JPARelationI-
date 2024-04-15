package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.API.APIException;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repositry.CourseRepository;
import com.example.exercisejparelationi.Repositry.StudentRepositry;
import com.example.exercisejparelationi.Repositry.TeacherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepositry teacherRepositry;
    private final StudentRepositry studentRepositry;

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
        if (courseRepository.findById(id) == null) throw new APIException("Course not found");
        else course.setName(course.getName());

        courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        if (courseRepository.findById(id) == null) {
            throw new APIException("Course not found with id : " + id);
        } else {
            Course course = courseRepository.getById(id);

            courseRepository.delete(course);
        }
    }

    public String getTeacherName(Integer courseId) {
        if (courseRepository.getById(courseId) == null) {
            throw new APIException("Course not found");
        }
        Course course = courseRepository.getById(courseId);
        Teacher teacher = course.getTeacher();
        if (teacher != null) {
            return teacher.getName();
        } else {
            throw new APIException("Teacher not found for course ");
        }
    }

//
    public Set<Student> getListStudent(Integer courseID){
        Course course=courseRepository.getById(courseID);
        if (course!=null){
            if (!course.getStudents().isEmpty()){
            return course.getStudents();}
            else {throw new APIException("no students added this course"+courseID);}
        }
        else {throw new APIException("No course with ID"+courseID);}
    }

    public void addStudentsTocourse(Integer courseID, Integer studentID){
        Student student=studentRepositry.findStudentById(studentID);
        Course course=courseRepository.getById(courseID);
        if (student==null  || course==null){
            throw new APIException("Cant add Student To Course ");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepositry.save(student);
        courseRepository.save(course);
    }

//}

}