package com.kingmj.api.common.dto;

import com.kingmj.api.common.code.ErrorCode;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
  private String code;
  private String message;
  private T result;
  public ApiResponse() {
    this.code = "S000";
  }
  // 요청에 성공 - 리턴 값이 존재함
  public ApiResponse success(String message, T result){
    this.message=message;
    this.result=result;
    return this;
  }
  // 요청에 성공 - 리턴 값이 존재하지 않음
  public ApiResponse success(String message){
    this.message=message;
    this.result=null;
    return this;
  }
  // 요청에 실패
  public ApiResponse(ErrorCode code) {
    this.message = code.getMessage();
    this.code = code.getCode();
    this.result = null;
  }
  public static ApiResponse of(ErrorCode code) {
    return new ApiResponse(code);
  }
}
