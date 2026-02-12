package com.example.repoonlinevideo.domain.lecture.service;

import com.example.repoonlinevideo.domain.lecture.presentation.dto.Response.LectureReadResponse;
import com.example.repoonlinevideo.domain.subcribe.domain.Subcribe;
import com.example.repoonlinevideo.domain.subcribe.domain.repository.SubcribeRepository;
import com.example.repoonlinevideo.domain.user.domain.User;
import com.example.repoonlinevideo.domain.user.domain.repository.UserRepository;
import com.example.repoonlinevideo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureReadMineService {
    private final SubcribeRepository subcribeRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public List<LectureReadResponse> getSubcribeByUserId() {
        User user = userRepository.findById(userFacade.currentUserId())
                .orElseThrow(() -> new RuntimeException("현재유저없음"));

        List<Subcribe> subcribes = subcribeRepository.findByUser(user);

        return subcribes.stream()
                .map(subcribe -> new LectureReadResponse(subcribe.getLecture()))
                .collect(Collectors.toList());
    }
}
