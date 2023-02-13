package com.kingmj.api.common.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ServerCode {
    //SUCCESS CODE
    LOGIN_SUCCESS("S000", "로그인을 성공했습니다."),
    POST_SUCCESS("S001", "글 등록을 성공했습니다."),
    LIST_SUCCESS("S002", "글 출력을 성공했습니다."),
    UPDATE_SUCCESS("S003", "글 수정을 성공했습니다."),
    DELETE_SUCCESS("S004", "글 삭제를 성공했습니다."),

    // FAIL CODE
    //HTTP Status : 401 (Unauthorized)
    EXPIRE_TOKEN("U000", "토큰이 만료되었습니다."),
    INVALID_TOKEN("U001", "토큰이 유효하지않습니다."),
    INVALID_QUESTION("U002", "등록되지 않은 질문입니다."),
    INVALID_ANSWER("U003", "유효하지 않은 답변입니다."),
    INVALID_ACCESS("U004", "등록되지 않은 사용자입니다.");
    private String code;
    private String message;
    ServerCode(String code, String message) {
        this.code=code;
        this.message=message;
    }

}
