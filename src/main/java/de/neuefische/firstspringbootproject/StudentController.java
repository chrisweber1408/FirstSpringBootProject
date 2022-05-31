package de.neuefische.firstspringbootproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")


public class StudentController {

    @GetMapping
    public List<Student> getStudent(){
        return List.of(
                new Student("Hans", "Gruber", 32),
                new Student("Klaus","Mueller", 56),
                new Student("Isa", "Schmitz", 29)
        );
    }
}
