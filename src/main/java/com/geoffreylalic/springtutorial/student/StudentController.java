package com.geoffreylalic.springtutorial.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class StudentController {

    StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> listStudentByFirstName(@PathVariable("student-name") String studentName) {
        return studentService.listStudentByFirstName(studentName);
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto getStudentById(@PathVariable("student-id") Integer studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> listStudents() {
        return studentService.listStudents();
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer studentId) {
        studentService.deleteStudent(studentId);
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
