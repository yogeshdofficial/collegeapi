package com.yogeshdofficial.collegeapi.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.yogeshdofficial.collegeapi.dtos.CollegeDto;
import com.yogeshdofficial.collegeapi.entities.College;

@Component
public class CollegeMapper implements Mapper<College, CollegeDto> {

  ModelMapper modelMapper;

  public CollegeMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public CollegeDto toDto(College college) {
    return modelMapper.map(college, CollegeDto.class);
  }

  public College toEntity(CollegeDto collegeDto) {
    return modelMapper.map(collegeDto, College.class);
  }
}
