package com.yogeshdofficial.collegeapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.yogeshdofficial.collegeapi.Api.ApiResponse;
import com.yogeshdofficial.collegeapi.dtos.CollegeDto;
import com.yogeshdofficial.collegeapi.repos.CollegeRepo;
import com.yogeshdofficial.collegeapi.services.CollegeService;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("colleges")
public class CollegeController {
  CollegeRepo collegeRepo;
  CollegeService collegeService;

  public CollegeController(CollegeRepo collegeRepo, CollegeService collegeService) {
    this.collegeRepo = collegeRepo;
    this.collegeService = collegeService;
  }

  @GetMapping("/")
  public ResponseEntity<ApiResponse<List<CollegeDto>>> getColleges(Pageable pageable,
      @RequestParam(name = "state", required = false) String state,
      @RequestParam(name = "district", required = false) String district,
      @RequestParam(name = "type", required = false) String type,
      @RequestParam(name = "collegename", required = false) String collegeName,
      @RequestParam(name = "universityname", required = false) String universityName) {

    ApiResponse<List<CollegeDto>> response = new ApiResponse<>();
    List<CollegeDto> colleges = collegeService.getColleges(collegeName, state, district,
        type, universityName, pageable);
    response.setData(colleges);
    response.setMessage("Colleges retrieved successfully.");
    response.setStatus("OK");
    response.setError(false);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<CollegeDto>> getCollegeById(@PathVariable Long id) {
    ApiResponse<CollegeDto> response = new ApiResponse<>();
    CollegeDto college = collegeService.getCollegeById(id);
    if (college == null) {
      response.setData(null);
      response.setMessage(String.format("College not found for id %s", id));
      response.setError(true);
      response.setStatus("not found");
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    } else {
      response.setData(college);
      response.setMessage(String.format("College found for id %s", id));
      response.setError(false);
      response.setStatus("success");
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
  }
}
