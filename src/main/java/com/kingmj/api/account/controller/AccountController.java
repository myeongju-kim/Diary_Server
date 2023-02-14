package com.kingmj.api.account.controller;

import com.kingmj.api.account.dto.LoginRequest;
import com.kingmj.api.account.dto.LoginResponse;
import com.kingmj.api.account.service.AccountService;
import com.kingmj.api.common.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
  private final AccountService accountService;
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }
  @Operation(summary = "로그인", description = "로그인을 진행합니다.")
  @PostMapping("/login")
  public ResponseEntity<ApiResponse<LoginResponse>> userLogin(@RequestBody LoginRequest loginRequest){
    return ResponseEntity.status(200).body(accountService.login(loginRequest));
  }
}
