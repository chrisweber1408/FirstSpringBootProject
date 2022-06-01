package de.neuefische.firstspringbootproject.students;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    private final Map<String, Student> students = new HashMap<>();

    public Optional<Student> findById(String id) {
        return Optional.ofNullable(students.get(id));
    }

    public Collection<Student> findAll() {
        return Collections.unmodifiableCollection(students.values());
    }

    public void save(Student student) {
        students.put(student.getId(), student);
    }
}
