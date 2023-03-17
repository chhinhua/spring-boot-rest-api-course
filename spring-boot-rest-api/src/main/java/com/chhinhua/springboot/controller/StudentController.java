package com.chhinhua.springboot.controller;

import com.chhinhua.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chhin_Hua - 17/03
 **/

@RestController
public class StudentController {

    // localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "chhinhua",
                "nguyen"
        );
        return ResponseEntity.ok()
                .header("custom-header", "chhinhua")
                .body(student);
    }

    // localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add((new Student(1, "John Doe", "Nguyen")));
        students.add((new Student(2, "John Doe", "Nguyen")));
        students.add((new Student(3, "John Doe", "Nguyen")));

        return ResponseEntity.ok(students);
    }

    // localhost:8080/student/1/chhin/hua
    @GetMapping("student/{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("firstName") String firstName,
                                                       @PathVariable("lastName") String lastName) {
        Student student = new Student(studentId, firstName, lastName);

        return ResponseEntity.ok(student);
    }

    // localhost:8080/students/query?id=1&firstName=chhin&lastName=hua
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestParam(@RequestParam int id,
                                                       @RequestParam String firstName,
                                                       @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);

        return ResponseEntity.ok(student);
    }

    // localhost:8080/students/create
    @PostMapping("students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // localhost:8080/students/1/update
    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId) {

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return ResponseEntity.ok(student);
    }

    // Delete student with @DeleteMapping annotation
    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {

        System.out.println(studentId);

        return ResponseEntity.ok("Student deleted successfully!");
    }

}
