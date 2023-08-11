package com.kingmj.api.common.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ServerCode {
    // SUCCESS CODE
    LOGIN_SUCCESS("S000", "로그인을 성공했습니다."),

    CHECK_SUCCESS("S001", "인증에 성공했습니다."),

    POST_SUCCESS("S002", "글 등록을 성공했습니다."),

    LIST_SUCCESS("S003", "모든 글 출력을 성공했습니다."),

    DETAIL_SUCCESS("S004", "상세 내용 보기에 성공했습니다."),

    UPDATE_SUCCESS("S005", "글 수정을 성공했습니다."),

    DELETE_SUCCESS("S006", "글 삭제를 성공했습니다."),

    // FAIL CODE
    // HTTP Status : 400 (Bad Request)
    BAD_REQUEST("B000", "파라미터 요청이 잘못되었습니다."),

    // HTTP Status : 401 (Unauthorized)
    EXPIRE_TOKEN("U000", "토큰이 만료되었습니다."),

    INVALID_TOKEN("U001", "토큰이 유효하지않습니다."),

    INVALID_QUESTION("U002", "등록되지 않은 질문입니다."),

    INVALID_ANSWER("U003", "유효하지 않은 답변입니다."),

    INVALID_ACCESS("U004", "등록되지 않은 사용자입니다."),

    // HTTP Status : 404 (Not Found)
    NOT_FOUND_NOTE("N000", "삭제되었거나 없는 게시글 입니다."),

    // HTTP Status : 500 (Internal Server Error)
    INTERNAL_SERVER_ERROR("S000", "예상치 못한 서버 오류입니다.");

    private String code;

    private String message;

    ServerCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
