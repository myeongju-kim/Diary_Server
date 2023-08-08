package com.kingmj.api.account.dto;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class LoginRequest {

    private int type;

    private String answer;

}
