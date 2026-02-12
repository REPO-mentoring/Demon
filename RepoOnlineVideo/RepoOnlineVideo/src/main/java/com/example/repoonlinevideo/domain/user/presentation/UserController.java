package com.example.repoonlinevideo.domain.user.presentation;

import com.example.repoonlinevideo.domain.user.presentation.dto.request.LoginRequest;
import com.example.repoonlinevideo.domain.user.presentation.dto.request.SignupRequest;
import com.example.repoonlinevideo.domain.user.presentation.dto.response.LoginResponse;
import com.example.repoonlinevideo.domain.user.service.LoginService;
import com.example.repoonlinevideo.domain.user.service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final LoginService loginService;
    private final SignupService signupService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@Valid @RequestBody SignupRequest signupRequest) {
        signupService.signUp(signupRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
}
