package com.geoffreylalic.springtutorial;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentResponseDto toResponseDto(Student student);
    List<StudentResponseDto> toResponseDtos(List<Student> students);
}
