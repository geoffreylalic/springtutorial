package com.geoffreylalic.springtutorial.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto createStudent(StudentDto studentDto) {
        Student student = studentMapper.toStudent(studentDto);
        Long nbStudents = studentRepository.countStudentsByEmail(student.getEmail());
        if (nbStudents > 0) {
            return null;
        }
        studentRepository.save(student);
        return studentMapper.toResponseDto(student);
    }

    public List<StudentResponseDto> listStudentByFirstName(String studentName) {
        List<Student> students = studentRepository.findAllByFirstNameContaining(studentName);
        return studentMapper.toResponseDtos(students);
    }

    public StudentResponseDto getStudentById(Integer studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return studentMapper.toResponseDto(student);
        }
        return null;
    }

    public List<StudentResponseDto> listStudents() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.toResponseDtos(students);
    }

    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

}
