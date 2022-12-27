package com.kingmj.api.common.code;

import lombok.Getter;

@Getter
public enum ErrorCode {
  // HTTP Status : 401 (Unauthorized)
  EXPIRE_TOKEN("U000", "토큰이 만료되었습니다."),
  INVALID_TOKEN("U001", "토큰이 유효하지않습니다."),
  INVALID_QUESTION("U002", "등록되지 않은 질문입니다."),
  INVALID_ANSWER("U003", "유효하지 않은 답변입니다."),
  INVALID_ACCESS("U004", "등록되지 않은 사용자입니다.");

  private String code;
  private String message;
  ErrorCode(String code, String message) {
    this.code=code;
    this.message=message;
  }
}
