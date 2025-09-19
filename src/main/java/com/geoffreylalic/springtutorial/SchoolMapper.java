package com.geoffreylalic.springtutorial;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolResponseDto toResponseDto (School school);
    List<SchoolResponseDto> toResponseDtos (List<School> schools);
}
