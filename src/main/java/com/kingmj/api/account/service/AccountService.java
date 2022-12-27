package com.kingmj.api.account.service;

import com.kingmj.api.account.dto.LoginRequest;
import com.kingmj.api.account.dto.LoginResponse;
import com.kingmj.api.common.code.ErrorCode;
import com.kingmj.api.common.dto.ServerResponse;
import com.kingmj.api.common.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  @Value("${login.information.army}")
  private String armyAnswer;
  @Value("${login.information.gun}")
  private String gunAnswer;
  @Value("${login.information.door}")
  private String doorAnswer;
  private final JwtService jwtService;
  private ServerResponse serverResponse=new ServerResponse();
  public AccountService(JwtService jwtService) {
    this.jwtService = jwtService;
  }
  public ServerResponse login(LoginRequest loginRequest){
    String[] correct={armyAnswer,gunAnswer,doorAnswer};
    Integer type=loginRequest.getType();
    String answer=loginRequest.getAnswer();
    if(type>2){
      throw new UnauthorizedException(ErrorCode.INVALID_QUESTION);
    }
    if(!answer.equals(correct[type])){
      throw new UnauthorizedException(ErrorCode.INVALID_ANSWER);
    }
    LoginResponse loginResponse=new LoginResponse(jwtService.createToken());
    return serverResponse.success("로그인에 성공했습니다.",loginResponse);
  }
}
