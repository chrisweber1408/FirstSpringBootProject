package de.neuefische.firstspringbootproject;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudent(String id) {
        return studentRepository.findById(id);
    }

    public Collection<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }
}