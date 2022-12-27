package com.kingmj.api.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
  private Integer type;
  private String answer;
}
