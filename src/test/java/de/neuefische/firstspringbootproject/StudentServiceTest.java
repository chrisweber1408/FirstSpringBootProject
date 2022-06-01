package de.neuefische.firstspringbootproject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    @Test
    void shouldReturnStudent(){
        //given
        Student student = new Student("Gruber","Hans");
        StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
        when(studentRepository.findById("1234")).thenReturn(Optional.of(student));
        StudentService studentService = new StudentService(studentRepository);

        //when
        Optional<Student> actual = studentService.getStudent("1234");

        //then
        Assertions.assertThat(actual).contains(student);
    }

    @Test
    void shouldNotFindStudent(){
        Student student = new Student("Gruber", "Hans");
        StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
        when(studentRepository.findById("1234")).thenReturn(Optional.of(student));
        StudentService studentService = new StudentService(studentRepository);

        //when
        Optional<Student> actual = studentService.getStudent("1233");

        //then
        Assertions.assertThat(actual).isEmpty();
    }

    @Test
    void shouldReturnAllStudents(){
        //given
        Student s1 = new Student("Gruber","Hans");
        Student s2 = new Student("Müller","Peter");
        Student s3 = new Student("Schmitz","Lisa");
        StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
        when(studentRepository.findAll()).thenReturn(List.of(s1,s2,s3));
        StudentService studentService = new StudentService(studentRepository);

        //when
        Collection<Student> actual = studentService.getStudents();

        //then
        Assertions.assertThat(actual)
                .isUnmodifiable()
                .isEqualTo(List.of(s1,s2,s3));
    }
    @Test
    void shouldSaveStudent(){

        //given
        Student s1 = new Student("Gruber","Hans");
        StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
        StudentService studentService = new StudentService(studentRepository);

        //when
        studentService.createStudent(s1);
        //then
        Mockito.verify(studentRepository).save(s1);
    }

}












