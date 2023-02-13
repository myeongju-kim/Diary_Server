package com.kingmj.api.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LoginRequest {
  private Integer type;
  private String answer;
}
