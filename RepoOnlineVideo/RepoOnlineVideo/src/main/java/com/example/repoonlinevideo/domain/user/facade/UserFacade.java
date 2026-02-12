package com.example.repoonlinevideo.domain.user.facade;

import com.example.repoonlinevideo.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public Long currentUserId() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByUsername(accountId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다.")).getId();
    }
}
