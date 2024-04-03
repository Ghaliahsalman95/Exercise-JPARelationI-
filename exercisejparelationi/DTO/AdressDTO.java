package com.example.exercisejparelationi.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.apache.bcel.classfile.InnerClass;

@Data
@AllArgsConstructor

public class AdressDTO {
    private Integer teacher_id;
    @NotEmpty@Size(min = 20,message = "at least 20charc")
    private String area;
    @NotEmpty@Size(min = 20,message = "at least 20charc")
    private String street;
    @NotEmpty@Size(min = 20,message = "at least 20charc")
    private String buildingNumber;
}
