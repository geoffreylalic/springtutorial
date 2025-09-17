package com.geoffreylalic.springtutorial;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class StudentController {

    private final StudentRepository repository;


    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        Long nbStudents = repository.countStudentsByEmail(student.getEmail());
        if (nbStudents > 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student already exists.");
        }
        repository.save(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }


    @GetMapping("/students/search/{student-name}")
    public List<Student> getStudentsByName(@PathVariable("student-name") String studentName) {
        return repository.findAllByFirstNameContaining(studentName);
    }

    @GetMapping("/students/{student-id}")
    public Student postStudent(@PathVariable("student-id") Integer studentId) {
        return repository.findById(studentId).orElse(null);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer studentId) {
        repository.deleteById(studentId);
    }


    // ==== basic rest apis ====

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.CREATED)
    public String sayHello2() {
        return "Hello World2";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Posted successfully and message is " + message;
    }


    @GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String username) {
        return "Hello " + username;
    }

    @GetMapping("/hello/param")
    public String paramVar(@RequestParam("userName") String username) {
        return "Hello " + username;
    }
}
