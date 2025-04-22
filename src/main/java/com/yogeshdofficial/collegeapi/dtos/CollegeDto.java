package com.yogeshdofficial.collegeapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeDto {
  long id;
  String universityName;
  String collegeName;
  String collegeType;
  String state;
  String district;
}
