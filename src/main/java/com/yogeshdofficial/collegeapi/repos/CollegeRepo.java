package com.yogeshdofficial.collegeapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yogeshdofficial.collegeapi.entities.College;

@Repository
public interface CollegeRepo extends JpaRepository<College, Long>, JpaSpecificationExecutor<College> {

  @Query("SELECT DISTINCT college.state FROM College college")
  List<String> findDistinctStates();

  @Query("SELECT DISTINCT college.district FROM College college")
  List<String> findDistinctDistricts();

  @Query("SELECT DISTINCT college.universityName FROM College college")
  List<String> findDistinctUniversities();

}