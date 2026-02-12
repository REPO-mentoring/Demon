package com.example.repoonlinevideo.domain.subcribe.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SubcribeRequest {
    private Long lectureId;

    public SubcribeRequest(Long lectureId) {
        this.lectureId = lectureId;
    }
}
