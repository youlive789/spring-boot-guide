package com.spring.guide.guide.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.guide.guide.ten.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sign/")
@RequiredArgsConstructor
public class SignController {
    private final SignService signService;

    @PostMapping("/sign-in")
    public SignInResultDto signIn(@RequestParam String id, @RequestParam String password) throws BusinessException {
        return signService.signIn(id, password);
    }

    @PostMapping("/sign-up")
    public SignUpResultDto signUp(
            @RequestParam String id, 
            @RequestParam String password,
            @RequestParam String name,
            @RequestParam String role
            ) {
        return signService.signUp(id, password, name, role);
    }
}
