package com.yogeshdofficial.collegeapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.yogeshdofficial.collegeapi.configs.specifications.CollegeSpecification;
import com.yogeshdofficial.collegeapi.dtos.CollegeDto;
import com.yogeshdofficial.collegeapi.entities.College;
import com.yogeshdofficial.collegeapi.mappers.CollegeMapper;
import com.yogeshdofficial.collegeapi.repos.CollegeRepo;

@Service
public class CollegeService {
  CollegeRepo collegeRepo;
  CollegeMapper collegeMapper;

  public CollegeService(CollegeRepo collegeRepo, CollegeMapper collegeMapper) {
    this.collegeRepo = collegeRepo;
    this.collegeMapper = collegeMapper;
  }

  public List<CollegeDto> getColleges(String collegeName, String state, String district, String type,
      String universityName, Pageable pageable) {
    Page<College> colleges = collegeRepo.findAll(
        CollegeSpecification.filterBy(collegeName, state, district, type, universityName),
        pageable);
    // for (College college : colleges) {
    // System.out.println(college);
    // }
    return colleges.stream().map(collegeMapper::toDto).toList();
  }

  public CollegeDto getCollegeById(long id) {
    Optional<College> college = collegeRepo.findById(id);
    return college.map(collegeMapper::toDto).orElse(null);
  }

  public List<String> getStates() {
    return collegeRepo.findDistinctStates();
  }

  public List<String> getDistricts() {
    return collegeRepo.findDistinctDistricts();
  }

  public List<String> getUniversities() {
    return collegeRepo.findDistinctUniversities();
  }
}
