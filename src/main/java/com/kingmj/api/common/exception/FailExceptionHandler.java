package com.kingmj.api.common.exception;

import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.util.ApiResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class FailExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ApiResponseEntity<Void> badRequestHandle(BadRequestException e){
        return ApiResponseEntity.error(HttpStatus.BAD_REQUEST, e.getServerCode());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ApiResponseEntity<Void> unauthorizedHandle(UnauthorizedException e) {
        return ApiResponseEntity.error(HttpStatus.UNAUTHORIZED, e.getServerCode());
    }

    @ExceptionHandler(NotFoundException.class)
    public ApiResponseEntity<Void> badRequestHandle(NotFoundException e){
        return ApiResponseEntity.error(HttpStatus.NOT_FOUND, e.getServerCode());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponseEntity<Void> exceptionHandle(Exception e){
        return ApiResponseEntity.error(HttpStatus.INTERNAL_SERVER_ERROR, ServerCode.INTERNAL_SERVER_ERROR);
    }
}
