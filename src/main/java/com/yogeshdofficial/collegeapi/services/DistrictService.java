package com.yogeshdofficial.collegeapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yogeshdofficial.collegeapi.repos.CollegeRepo;

@Service
public class DistrictService {

  private final CollegeRepo collegeRepo;

  public DistrictService(CollegeRepo collegeRepo) {
    this.collegeRepo = collegeRepo;
  }

  public List<String> getAllDistricts() {
    return collegeRepo.findDistinctDistricts();
  }
}
