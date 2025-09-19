package com.geoffreylalic.springtutorial.school;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public School createSchool(SchoolDto schoolDto) {
        return schoolRepository.save(schoolMapper.toSchool(schoolDto));
    }

    public List<SchoolResponseDto> listSchools(){
        List<School> schools = schoolRepository.findAll();
        return schoolMapper.toResponseDtos(schools);
    }


}
