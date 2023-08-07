package com.kingmj.api.common.dto;

import com.kingmj.api.common.code.ServerCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseEntity<T> extends ResponseEntity<ApiResponse<T>> {

    public ApiResponseEntity(HttpStatus httpStatus, ServerCode serverCode, T data) {
        super(new ApiResponse<>(serverCode.getCode(), serverCode.getMessage(), data), httpStatus);
    }

    public static <T> ApiResponseEntity<T> success(HttpStatus status, ServerCode serverCode, T data) {
        return new ApiResponseEntity<>(status, serverCode, data);
    }

    public static <T> ApiResponseEntity<T> success(HttpStatus status, ServerCode serverCode) {
        return new ApiResponseEntity<>(status, serverCode, null);
    }

    public static <T> ApiResponseEntity<T> error(HttpStatus status, ServerCode serverCode) {
        return new ApiResponseEntity<>(status, serverCode, null);
    }
}
