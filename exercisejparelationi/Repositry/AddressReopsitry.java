package com.example.exercisejparelationi.Repositry;

import com.example.exercisejparelationi.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressReopsitry extends JpaRepository<Address,Integer> {
    Address findAddressById(Integer id);
}
