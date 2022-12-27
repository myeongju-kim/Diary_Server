package com.kingmj.api.common.exception;

import com.kingmj.api.common.code.ErrorCode;
import com.kingmj.api.common.dto.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.kingmj.api")
public class FailExceptionHandler {
  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<ServerResponse> unauthorizedHandle(UnauthorizedException e){
    ErrorCode errorCode=e.getErrorCode();
    ServerResponse serverResponse=ServerResponse.of(errorCode);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(serverResponse);
  }
}
