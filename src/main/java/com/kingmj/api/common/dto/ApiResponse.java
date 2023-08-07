package com.kingmj.api.common.dto;

import com.kingmj.api.common.code.ServerCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ApiResponse<T> {

  String code;

  String message;

  private T result;

}
