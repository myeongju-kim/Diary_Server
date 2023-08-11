package com.kingmj.api.account.controller;

import com.kingmj.api.account.dto.LoginRequest;
import com.kingmj.api.account.dto.LoginResponse;
import com.kingmj.api.account.service.impl.AccountServiceImpl;
import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.util.ApiResponseEntity;
import com.kingmj.api.util.Auth;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "로그인을 진행합니다.")
    public ApiResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest) {
        return ApiResponseEntity.success(HttpStatus.OK, ServerCode.LOGIN_SUCCESS,
                                         accountService.getTokenIfLoginSucceeds(loginRequest));
    }

    @Auth
    @GetMapping("/login-check")
    @Operation(summary = "인증", description = "로그인이 되었는지 인증합니다.")
    public ApiResponseEntity<Void> userCheck() {
        return ApiResponseEntity.success(HttpStatus.OK, ServerCode.CHECK_SUCCESS);
    }
}
