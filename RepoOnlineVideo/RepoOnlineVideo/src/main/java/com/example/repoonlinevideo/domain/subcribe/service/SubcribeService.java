package com.example.repoonlinevideo.domain.subcribe.service;

import com.example.repoonlinevideo.domain.lecture.domain.Lecture;
import com.example.repoonlinevideo.domain.lecture.domain.repository.LectureRepository;
import com.example.repoonlinevideo.domain.subcribe.domain.Subcribe;
import com.example.repoonlinevideo.domain.subcribe.domain.repository.SubcribeRepository;
import com.example.repoonlinevideo.domain.subcribe.presentation.dto.request.SubcribeRequest;
import com.example.repoonlinevideo.domain.user.domain.User;
import com.example.repoonlinevideo.domain.user.domain.repository.UserRepository;
import com.example.repoonlinevideo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubcribeService {
    private final SubcribeRepository subcribeRepository;
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;
    private final UserFacade userFacade;

    public void subcribeLecture(Long lectureId, SubcribeRequest subcribeRequest) {
        User user = userRepository.findById(userFacade.currentUserId())
                .orElseThrow(() -> new RuntimeException("유저를 찾을수없음"));

        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("해당 강의를 찾을수없음"));

        final boolean ExistLectureAndUser = subcribeRepository.existsByUserAndLecture(user, lecture);
        if (ExistLectureAndUser) {
            throw new IllegalStateException("이미 신청하신 강의입니다.");
        }
        Subcribe subcribe = Subcribe.builder()
                .user(user)
                .lecture(lecture)
                .build();
        subcribeRepository.save(subcribe);
    }
}
