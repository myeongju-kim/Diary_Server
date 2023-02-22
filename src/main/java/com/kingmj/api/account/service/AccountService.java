package com.kingmj.api.account.service;

import com.kingmj.api.account.dto.LoginRequest;
import com.kingmj.api.account.dto.LoginResponse;
import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.common.dto.ApiResponse;
import com.kingmj.api.common.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  @Value("${login.information.army}")
  private String armyAnswer;
  @Value("${login.information.door}")
  private String doorAnswer;
  private final JwtService jwtService;
  public AccountService(JwtService jwtService) {
    this.jwtService = jwtService;
  }
  public ApiResponse<LoginResponse> login(LoginRequest loginRequest){
    String[] correct={armyAnswer,doorAnswer};
    loginRequest.getType();
    Integer type=loginRequest.getType();
    String answer=loginRequest.getAnswer();
    // index error
    if(type>1){
      throw new UnauthorizedException(ServerCode.INVALID_QUESTION);
    }
    // invalid answer
    if(!answer.equals(correct[type])){
      throw new UnauthorizedException(ServerCode.INVALID_ANSWER);
    }
    return ApiResponse.<LoginResponse>builder()
            .code(ServerCode.LOGIN_SUCCESS.getCode())
            .message(ServerCode.LOGIN_SUCCESS.getMessage())
            .result(LoginResponse.builder()
                    .token(jwtService.createToken())
                    .build())
            .build();
  }
}
