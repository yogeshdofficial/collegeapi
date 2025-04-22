package com.yogeshdofficial.collegeapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogeshdofficial.collegeapi.Api.ApiResponse;
import com.yogeshdofficial.collegeapi.services.DistrictService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("districts")
public class DistrictContoller {

  private final DistrictService districtService;

  public DistrictContoller(DistrictService districtService) {
    this.districtService = districtService;
  }

  @GetMapping("/")
  public ResponseEntity<ApiResponse<List<String>>> getDistinctDistricts() {
    List<String> districts = districtService.getAllDistricts();
    ApiResponse<List<String>> response = new ApiResponse<>();
    response.setData(districts);
    response.setMessage("List of districts returned");
    response.setError(false);
    response.setStatus("success");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
