package com.kingmj.api.common.exception;

import com.kingmj.api.common.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
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
