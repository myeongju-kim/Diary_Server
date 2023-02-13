package com.kingmj.api.common.exception;

import com.kingmj.api.common.code.ErrorCode;
import com.kingmj.api.common.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.kingmj.api")
public class FailExceptionHandler {
  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<ApiResponse> unauthorizedHandle(UnauthorizedException e){
    ErrorCode errorCode=e.getErrorCode();
    ApiResponse apiResponse = ApiResponse.of(errorCode);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(apiResponse);
  }
}
