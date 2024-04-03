package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.API.APIResponse;
import com.example.exercisejparelationi.DTO.AdressDTO;
import com.example.exercisejparelationi.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/address")
public class AddressController {

    Logger logger= LoggerFactory.getLogger(AddressController.class);
    private final AddressService addressService;
    @PostMapping("/add-address")
    public ResponseEntity add(@RequestBody @Valid AdressDTO AdressDTO){
        logger.info("inside add ");

        addressService.add(AdressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("add successfully"));
    }
    @GetMapping("get-all")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(addressService.get());
    }

    @PutMapping("/update-address")
    public ResponseEntity update(@RequestBody @Valid AdressDTO AdressDTO){
        logger.info("inside update ");

        addressService.update(AdressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("update successfully"));
    }
    @DeleteMapping("/delete-address/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        logger.info("inside delete ");

        addressService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("delete successfully"));
    }



}
