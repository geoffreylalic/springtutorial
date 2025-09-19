package com.geoffreylalic.springtutorial.school;

import com.geoffreylalic.springtutorial.student.StudentResponseDto;

import java.util.List;

public record SchoolResponseDto(Integer id, String name, List<StudentResponseDto> students) {
}
