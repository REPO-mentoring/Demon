package com.example.repoonlinevideo.domain.lecture.presentation.dto.Response;

import com.example.repoonlinevideo.domain.lecture.domain.Lecture;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LectureReadResponse {
    private Long id;
    private String title;

    public LectureReadResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.title = lecture.getTitle();
    }
}
