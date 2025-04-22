package com.yogeshdofficial.collegeapi.Api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApiResponse<T> {
  private String status;
  private String message;
  private T data;
  private Object metadata;
  private boolean error;
}
