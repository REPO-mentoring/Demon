package com.example.repoonlinevideo.domain.user.service;

import com.example.repoonlinevideo.domain.user.domain.User;
import com.example.repoonlinevideo.domain.user.domain.repository.UserRepository;
import com.example.repoonlinevideo.domain.user.presentation.dto.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignupRequest signupRequest) {
        userRepository.save(
                User.builder()
                        .username(signupRequest.getUsername())
                        .password(passwordEncoder.encode(signupRequest.getPassword()))
                        .build()
        );
    }
}
