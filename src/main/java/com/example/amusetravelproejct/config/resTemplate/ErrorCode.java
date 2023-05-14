package com.example.amusetravelproejct.config.resTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    /* 400 BAD_REQUEST : 잘못된 요청 */
    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "권한 정보가 없는 토큰입니다."),

    /* 404 NOT_FOUND : Resource를 찾을 수 없음 */
    ITEM_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 상품은 존재하지 않습니다"),
    EXIT_LIKE_ITEM(HttpStatus.MULTI_STATUS,"좋아요를 이미 누른 상품입니다."),
    NOT_EXIT_LIKE_ITEM(HttpStatus.NOT_FOUND,"좋아요를 누른 상품이 아닙니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 유저를 찾을 수 없습니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED,"access token이 만료되었습니다"),
    NOT_EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED,"access token이 만료되지 않았습니다."),
    INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED,"유효하지 않는 access token 입니다."),
    CLAIM_NULL(HttpStatus.NOT_EXTENDED,"user claim이 존재하지 않습니다."),
    ADMIN_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 관리자를 찾을 수 없습니다."),
    DISPLAY_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 카테고리를 찾을 수 없습니다.");


    private final HttpStatus httpStatus;
    private final String message;
}
