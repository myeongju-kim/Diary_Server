package com.kingmj.api.common.exception;

import com.kingmj.api.common.code.ServerCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class ParameterNullChecker {

    private ParameterNullChecker() {}

    public static <T> T requireNonNull(T obj) {
        return Optional.ofNullable(obj)
                       .orElseThrow(() -> new BadRequestException(ServerCode.BAD_REQUEST));

    }

}
