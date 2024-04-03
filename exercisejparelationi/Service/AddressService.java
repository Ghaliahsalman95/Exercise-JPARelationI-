package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.API.APIException;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repositry.AddressReopsitry;
import com.example.exercisejparelationi.Repositry.TeacherRepositry;
import com.example.exercisejparelationi.DTO.AdressDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressReopsitry addressReopsitry;
private final TeacherRepositry teacherRepositry;


    public List<com.example.exercisejparelationi.Model.Address> get(){
        return addressReopsitry.findAll();
    }
    public void add(AdressDTO AddressDTO){
        Teacher teacher=teacherRepositry.findTeacherById(AddressDTO.getTeacher_id());
        if (teacher!=null){
            Address address=new Address(null,AddressDTO.getArea(),AddressDTO.getStreet(),AddressDTO.getBuildingNumber(),teacher);
            addressReopsitry.save(address);
        }
        else throw  new APIException("Not found teacher id");
    }

    public void update(AdressDTO addressDTO){
        Address address=addressReopsitry.findAddressById(addressDTO.getTeacher_id());
        if (address!=null){
            address.setArea(addressDTO.getArea());
            address.setTeacher(teacherRepositry.findTeacherById(addressDTO.getTeacher_id()));
            address.setStreet(addressDTO.getStreet());
            address.setBuildingNumber(addressDTO.getBuildingNumber());
            addressReopsitry.save(address);
        }
        else throw  new APIException("Not found address id");
    }

    public void delete(Integer id){
        Address address=addressReopsitry.findAddressById(id);
        if (address!=null){
            addressReopsitry.delete(address);
        }else throw  new APIException("Not found address id");
    }

}
