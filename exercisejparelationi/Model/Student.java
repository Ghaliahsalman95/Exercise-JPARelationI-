package com.example.exercisejparelationi.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Data@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //ID , name , age , major ( all should not be empty )
    @NotEmpty(message = "name not empty")
    private String name;
    @NotNull(message = "age not empty")
    private Integer age ;
    @NotEmpty(message = "major not empty")
    private String major;

    @ManyToMany(mappedBy = "students")//same spilling in next model
    private Set<Course> courses;

}
