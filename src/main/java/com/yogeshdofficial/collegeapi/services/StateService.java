package com.yogeshdofficial.collegeapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yogeshdofficial.collegeapi.repos.CollegeRepo;

@Service
public class StateService {

  private final CollegeRepo collegeRepo;

  public StateService(CollegeRepo collegeRepo) {
    this.collegeRepo = collegeRepo;
  }

  public List<String> getAllStates() {
    return collegeRepo.findDistinctStates();
  }
}
