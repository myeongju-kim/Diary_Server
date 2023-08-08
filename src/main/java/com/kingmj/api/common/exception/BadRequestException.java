package com.kingmj.api.common.exception;

import com.kingmj.api.common.code.ServerCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private ServerCode serverCode;

    public BadRequestException(ServerCode serverCode) {
        this.serverCode = serverCode;
    }
}
