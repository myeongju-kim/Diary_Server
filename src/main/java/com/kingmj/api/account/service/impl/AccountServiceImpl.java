package com.kingmj.api.account.service.impl;

import com.kingmj.api.account.dto.LoginRequest;
import com.kingmj.api.account.dto.LoginResponse;
import com.kingmj.api.account.service.AccountService;
import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.common.dto.ApiResponse;
import com.kingmj.api.common.exception.ParameterNullChecker;
import com.kingmj.api.common.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Value("${login.information.army}")
    private String armyAnswer;

    @Value("${login.information.door}")
    private String doorAnswer;

    private final JwtServiceImpl jwtService;

    @Override
    public LoginResponse getTokenIfLoginSucceeds(LoginRequest loginRequest) {

        String[] correct = {armyAnswer, doorAnswer};

        int type = loginRequest.getType();
        String answer = ParameterNullChecker.requireNonNull(loginRequest.getAnswer());

        // index error
        if (type > 1) {
            throw new UnauthorizedException(ServerCode.INVALID_QUESTION);
        }
        // invalid answer
        if (!answer.equals(correct[type])) {
            throw new UnauthorizedException(ServerCode.INVALID_ANSWER);
        }

        return LoginResponse.builder()
                            .token(jwtService.createToken())
                            .build();
    }

}
