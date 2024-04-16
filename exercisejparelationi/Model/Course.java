package com.example.exercisejparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = " name can't be null ")
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;


    @ManyToMany
    @JsonIgnore
    private Set<Student> students;//same spilling in [mappedBy = "students"] model in student;


}