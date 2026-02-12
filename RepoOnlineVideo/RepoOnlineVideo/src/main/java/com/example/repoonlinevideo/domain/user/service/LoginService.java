package com.example.repoonlinevideo.domain.user.service;

import com.example.repoonlinevideo.domain.user.domain.User;
import com.example.repoonlinevideo.domain.user.domain.repository.UserRepository;
import com.example.repoonlinevideo.domain.user.presentation.dto.request.LoginRequest;
import com.example.repoonlinevideo.domain.user.presentation.dto.response.LoginResponse;
import com.example.repoonlinevideo.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호 불일치");
        }
        String accessToken =
                jwtTokenProvider.generateAccessToken(user.getUsername());

        String refreshToken =
                jwtTokenProvider.generateRefreshToken(user.getUsername());


        return new LoginResponse(accessToken, refreshToken);
    }
}
