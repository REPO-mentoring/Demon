package com.example.repoonlinevideo.domain.lecture.service;

import com.example.repoonlinevideo.domain.lecture.domain.Lecture;
import com.example.repoonlinevideo.domain.lecture.domain.repository.LectureRepository;
import com.example.repoonlinevideo.domain.lecture.presentation.dto.Response.LectureReadResponse;
import com.example.repoonlinevideo.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureReadService {
    private final LectureRepository lectureRepository;

    public List<LectureReadResponse> readAll() {
        List<Lecture> lectures = lectureRepository.findAll();
        return lectures.stream()
                .map(LectureReadResponse::new)
                .collect(Collectors.toList());
    }
}
