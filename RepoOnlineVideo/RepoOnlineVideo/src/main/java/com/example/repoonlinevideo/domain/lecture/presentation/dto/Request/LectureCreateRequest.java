package com.example.repoonlinevideo.domain.lecture.presentation.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LectureCreateRequest {
    @NotBlank
    private String title;
    public LectureCreateRequest(String title) {
        this.title = title;
    }
}
