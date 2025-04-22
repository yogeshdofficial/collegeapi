package com.yogeshdofficial.collegeapi.configs.specifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.yogeshdofficial.collegeapi.entities.College;

import jakarta.persistence.criteria.Predicate;

public class CollegeSpecification {

  public static Specification<College> filterBy(String collegeName, String state, String district,
      String type,
      String universityName) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (collegeName != null && !collegeName.isEmpty()) {
        predicates.add(cb.like(cb.lower(root.get("collegeName")), "%" + collegeName.toLowerCase() + "%"));
      }
      if (state != null && !state.isEmpty()) {
        predicates.add(cb.like(cb.lower(root.get("state")), "%" + state.toLowerCase() + "%"));
      }
      if (district != null && !district.isEmpty()) {
        predicates.add(cb.like(cb.lower(root.get("district")), "%" + district.toLowerCase() + "%"));
      }
      if (type != null && !type.isEmpty()) {
        predicates.add(cb.like(cb.lower(root.get("type")), "%" + type.toLowerCase() + "%"));
      }
      if (universityName != null && !universityName.isEmpty()) {
        predicates.add(cb.like(cb.lower(root.get("universityName")), "%" + universityName.toLowerCase() + "%"));
      }
      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}
