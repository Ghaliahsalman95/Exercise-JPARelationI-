package com.example.exercisejparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")

    private String name;
    @Column(columnDefinition = "int not null")
    private int age;
    @Column(columnDefinition = "varchar(20) not null")
    private String email;
    @Column(columnDefinition = "int not null")
    private Integer salary;
//    @OneToOne(cascade = CascadeType.ALL,mappedBy ="teacher")
//    @PrimaryKeyJoinColumn// هذا تابع
//    private Address address;
//
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
//    private Set<Course> courses;
//


    //////////



    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;
}

