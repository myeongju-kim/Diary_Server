package com.kingmj.api.account.service;

import com.kingmj.api.account.dto.LoginRequest;
import com.kingmj.api.account.dto.LoginResponse;

public interface AccountService {

    LoginResponse getTokenIfLoginSucceeds(LoginRequest loginRequest);

}
