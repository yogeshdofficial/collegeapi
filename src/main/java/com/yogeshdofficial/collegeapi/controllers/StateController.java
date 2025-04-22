package com.yogeshdofficial.collegeapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogeshdofficial.collegeapi.Api.ApiResponse;
import com.yogeshdofficial.collegeapi.services.StateService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("states")
public class StateController {

  private final StateService stateService;

  public StateController(StateService stateService) {
    this.stateService = stateService;
  }

  @GetMapping("/")
  public ResponseEntity<ApiResponse<List<String>>> getDistinctDistricts() {
    List<String> districts = stateService.getAllStates();
    ApiResponse<List<String>> response = new ApiResponse<>();
    response.setData(districts);
    response.setMessage("List of states returned");
    response.setError(false);
    response.setStatus("success");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
