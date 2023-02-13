package com.kingmj.api.common.exception;

import com.kingmj.api.common.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.kingmj.api")
public class FailExceptionHandler {
  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<ApiResponse<Void>> unauthorizedHandle(UnauthorizedException e){

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(ApiResponse.<Void>builder()
                .code(e.getServerCode().getCode())
                .message(e.getServerCode().getMessage())
                .result(null)
                .build());
  }
}
