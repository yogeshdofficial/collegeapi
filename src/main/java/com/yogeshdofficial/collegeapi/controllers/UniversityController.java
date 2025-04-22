package com.yogeshdofficial.collegeapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogeshdofficial.collegeapi.Api.ApiResponse;
import com.yogeshdofficial.collegeapi.services.UniversityService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("universities")
public class UniversityController {

  private final UniversityService universityService;

  public UniversityController(UniversityService universityService) {
    this.universityService = universityService;
  }

  @GetMapping("/")
  public ResponseEntity<ApiResponse<List<String>>> getDistinctDistricts() {
    List<String> districts = universityService.getAllUniversities();
    ApiResponse<List<String>> response = new ApiResponse<>();
    response.setData(districts);
    response.setMessage("List of universities returned");
    response.setError(false);
    response.setStatus("success");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
