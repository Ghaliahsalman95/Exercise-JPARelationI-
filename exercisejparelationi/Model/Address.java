package com.example.exercisejparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @Column(columnDefinition = "varchar(20) not null")
    private String buildingNumber;
//    @OneToOne
//    @MapsId//only oneToOne relation its =    @PrimaryKeyJoinColumn
//    @JsonIgnore // infinite loop so when get address ignore address
//    private Teacher teacher;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
