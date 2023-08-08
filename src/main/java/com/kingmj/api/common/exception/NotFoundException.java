package com.kingmj.api.common.exception;

import com.kingmj.api.common.code.ServerCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private ServerCode serverCode;

    public NotFoundException(ServerCode serverCode) {
        this.serverCode = serverCode;
    }

}
