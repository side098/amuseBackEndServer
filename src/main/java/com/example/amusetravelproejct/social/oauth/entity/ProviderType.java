package com.example.amusetravelproejct.social.oauth.entity;

import lombok.Getter;

// 소셜 로그인 종류
@Getter
public enum ProviderType {
    GOOGLE,
    FACEBOOK,
    NAVER,
    KAKAO,
    LOCAL;
}
