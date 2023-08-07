package com.kingmj.api.common.exception;

import com.kingmj.api.common.code.ServerCode;
import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {

    private ServerCode serverCode;

    public UnauthorizedException(ServerCode serverCode) {
        this.serverCode = serverCode;
    }

}
