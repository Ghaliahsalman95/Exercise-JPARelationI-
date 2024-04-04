package com.example.exercisejparelationi.Model;

import jakarta.persistence.*;
import lombok.*;

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
    @OneToOne(cascade = CascadeType.ALL,mappedBy ="teacher")
    @PrimaryKeyJoinColumn// هذا تابع
    private Address address;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Course> courses;
}

}
