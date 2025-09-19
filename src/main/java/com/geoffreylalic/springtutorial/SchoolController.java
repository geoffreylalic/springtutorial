package com.geoffreylalic.springtutorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolController(SchoolRepository repository, SchoolMapper schoolMapper) {
        this.schoolRepository = repository;
        this.schoolMapper = schoolMapper;
    }

    @PostMapping("/schools")
    public School createSchool(@RequestBody SchoolDto schoolDto) {
        School school = toSchool(schoolDto);
        return schoolRepository.save(school);
    }

    public School toSchool(SchoolDto schoolDto) {
        School school = new School();
        school.setName(schoolDto.name());
        return school;
    }

    @GetMapping("/schools")
    public List<SchoolResponseDto> listSchools() {
        List<School> schools = schoolRepository.findAll();
        return schoolMapper.toResponseDtos(schools);
    }


}
