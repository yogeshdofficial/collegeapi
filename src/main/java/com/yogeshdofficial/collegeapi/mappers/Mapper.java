package com.yogeshdofficial.collegeapi.mappers;

public interface Mapper<A, B> {
  B toDto(A entity);

  A toEntity(B dto);

}
