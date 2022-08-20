package com.spring.guide.guide.auth;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.guide.guide.config.security.UserDetails.Users;
import com.spring.guide.guide.config.security.UserDetails.UserRepository;
import com.spring.guide.guide.config.security.jwt.JwtTokenProvider;
import com.spring.guide.guide.ten.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignServiceImpl implements SignService{

    private final ModelMapper modelMapper;
    private final UserRepository repository;
    private final JwtTokenProvider provider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpResultDto signUp(String id, String password, String name, String role) {
        
        Users user = Users.builder()
            .uid(id)
            .name(name)
            .password(passwordEncoder.encode(password))
            .roles(Collections.singletonList("ROLE_ADMIN"))
            .build();

        Users saved = repository.save(user);
        return modelMapper.map(saved, SignUpResultDto.class);
    }

    @Override
    public SignInResultDto signIn(String id, String password) throws BusinessException {
        
        Users user = repository.getByUid(id);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BusinessException("패스워드 틀림", HttpStatus.FORBIDDEN);
        }

        SignInResultDto signInResultDto = SignInResultDto.builder()
            .token(provider.createToken(String.valueOf(user.getUid()), user.getRoles()))
            .build();

        return signInResultDto;
    }
    
}
