package com.kingmj.api.common.dto;

import com.kingmj.api.common.code.ServerCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {
  private String code;
  private String message;
  private T result;
}
