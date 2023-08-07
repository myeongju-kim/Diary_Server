package com.kingmj.api.common.exception;

import com.kingmj.api.common.dto.ApiResponse;
import com.kingmj.api.common.dto.ApiResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class FailExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ApiResponseEntity<Void> unauthorizedHandle(UnauthorizedException e) {
        return ApiResponseEntity.error(HttpStatus.UNAUTHORIZED, e.getServerCode());
    }
}
