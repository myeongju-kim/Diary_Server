package com.kingmj.api.common.dto;

import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.util.ApiResponseEntity;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ApiResponse<T> {

    private String code;

    private String message;

    private T result;

    public ApiResponse(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

}
