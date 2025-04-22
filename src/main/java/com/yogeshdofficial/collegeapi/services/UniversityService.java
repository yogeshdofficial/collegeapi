package com.yogeshdofficial.collegeapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yogeshdofficial.collegeapi.repos.CollegeRepo;

@Service
public class UniversityService {

  private final CollegeRepo collegeRepo;

  public UniversityService(CollegeRepo collegeRepo) {
    this.collegeRepo = collegeRepo;
  }

  public List<String> getAllUniversities() {
    return collegeRepo.findDistinctUniversities();
  }
}
