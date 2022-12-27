package com.kingmj.api.common.exception;

import com.kingmj.api.common.code.ErrorCode;
import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException{
  private ErrorCode errorCode;
  public UnauthorizedException(ErrorCode errorCode){
    this.errorCode=errorCode;
  }
}
