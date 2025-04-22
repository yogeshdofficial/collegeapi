package com.yogeshdofficial.collegeapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class College {
  @Id
  long id;
  @Column(columnDefinition = "TEXT", name = "university_name")
  String universityName;
  @Column(columnDefinition = "TEXT", name = "college_name")
  String collegeName;
  @Column(name = "college_type")
  String collegeType;
  String state;
  String district;
}
