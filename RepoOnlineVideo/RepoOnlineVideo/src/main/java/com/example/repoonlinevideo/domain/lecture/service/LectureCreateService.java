package com.example.repoonlinevideo.domain.lecture.service;

import com.example.repoonlinevideo.domain.lecture.domain.Lecture;
import com.example.repoonlinevideo.domain.lecture.domain.repository.LectureRepository;
import com.example.repoonlinevideo.domain.lecture.presentation.dto.Request.LectureCreateRequest;
import com.example.repoonlinevideo.domain.user.domain.User;
import com.example.repoonlinevideo.domain.user.domain.repository.UserRepository;
import com.example.repoonlinevideo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureCreateService {
    private final LectureRepository lectureRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public Lecture create(LectureCreateRequest lectureCreateRequest) {
    User user = userRepository.findById(userFacade.currentUserId())
            .orElseThrow(()->new IllegalArgumentException("유효하지 않은 사용자 정보입니다."));

    Lecture lecture = Lecture.builder()
            .user(user)
            .title(lectureCreateRequest.getTitle())
            .build();
    return lectureRepository.save(lecture);
    }
}
