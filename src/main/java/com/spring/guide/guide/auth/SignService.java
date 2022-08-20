package com.spring.guide.guide.auth;

import com.spring.guide.guide.ten.exception.BusinessException;

public interface SignService {
    SignUpResultDto signUp(String id, String password, String name, String role);

    SignInResultDto signIn(String id, String password) throws BusinessException;
}
