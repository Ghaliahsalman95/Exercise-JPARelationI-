package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.API.APIException;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repositry.TeacherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepositry teacherRepositry;

    public List<Teacher> getall(){
        return teacherRepositry.findAll();
    }

    public void add(Teacher teacher){
        teacherRepositry.save(teacher);
    }

    public void update(Integer id,Teacher teacher){
        if (teacherRepositry.findTeacherById(id)!=null){
            Teacher t=teacherRepositry.findTeacherById(id);
            t.setName(teacher.getName());
            t.setEmail(teacher.getEmail());
            t.setSalary(t.getSalary());
            t.setAddress(teacher.getAddress());
            t.setAge(teacher.getAge());

            teacherRepositry.save(t);
        }else throw new APIException("not found");
    }

    public void delete(Integer id){
        if (teacherRepositry.findTeacherById(id)!=null){
            teacherRepositry.delete(teacherRepositry.findTeacherById(id));
        }
        else throw new APIException("not found");
    }

    public Teacher getOne(Integer id){
        if (teacherRepositry.findTeacherById(id)!=null)
            return teacherRepositry.findTeacherById(id);
        else throw new APIException("Not found");
    }
}
