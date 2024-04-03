package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.API.APIResponse;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

    Logger logger = LoggerFactory.getLogger(TeacherController.class);
    private final TeacherService teacherService;
    @GetMapping("/get-all")
    public ResponseEntity get(){
        logger.info("inside get all");
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getall());
    }

    @PostMapping("add-teacher")
    public ResponseEntity add(@RequestBody @Valid Teacher teacher){
        logger.info("inside add ");

        teacherService.add(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Added successfully"));
    }

    @PutMapping("update-teacher/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Teacher teacher ){
        logger.info("inside update");

        teacherService.update(id,teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("updated successfully"));
    }

    @DeleteMapping("delete-teacher/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        logger.info("inside delete ");

        teacherService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Deleted successfully"));
    }
@GetMapping("/get/{id}")
    public ResponseEntity getOne(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getOne(id));
}

}
