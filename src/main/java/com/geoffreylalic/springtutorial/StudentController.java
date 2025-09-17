package com.geoffreylalic.springtutorial;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class StudentController {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;


    public StudentController(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto) {
        Student student = toStudent(studentDto);
        Long nbStudents = studentRepository.countStudentsByEmail(student.getEmail());
        if (nbStudents > 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student already exists.");
        }
        studentRepository.save(student);
        StudentResponseDto studentResponseDto = new StudentResponseDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
        return new ResponseEntity<StudentResponseDto>(studentResponseDto, HttpStatus.OK);
    }

    private Student toStudent(StudentDto studentDto) {
        School school = new School();
        school.setId(studentDto.schoolId());

        Student student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());
        student.setSchool(school);

        return student;
    }


    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> getStudentsByName(@PathVariable("student-name") String studentName) {
        List<Student> students = studentRepository.findAllByFirstNameContaining(studentName);
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
        for (Student student : students) {
            studentResponseDtos.add(new StudentResponseDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail()));
        }
        return studentResponseDtos;
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto postStudent(@PathVariable("student-id") Integer studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return new StudentResponseDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
        }
        return null;
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();

        for (Student student : students) {
            studentResponseDtos.add(new StudentResponseDto(student.getId(), student.getFirstName(), student.getFirstName(), student.getEmail()));
        }
        return studentResponseDtos;

    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("student-id") Integer studentId) {
        studentRepository.deleteById(studentId);
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
