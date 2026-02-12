package com.example.repoonlinevideo.domain.lecture.presentation;

import com.example.repoonlinevideo.domain.lecture.domain.Lecture;
import com.example.repoonlinevideo.domain.lecture.presentation.dto.Request.LectureCreateRequest;
import com.example.repoonlinevideo.domain.lecture.presentation.dto.Response.LectureReadResponse;
import com.example.repoonlinevideo.domain.lecture.service.LectureCreateService;
import com.example.repoonlinevideo.domain.lecture.service.LectureReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {

    private final LectureCreateService lectureCreateService;
    private final LectureReadService lectureReadService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void lectureCreate(@RequestBody LectureCreateRequest lectureCreateRequest) {
        lectureCreateService.create(lectureCreateRequest);
    }

    @GetMapping("/get-list")
    @ResponseStatus(HttpStatus.OK)
    public List<LectureReadResponse> getLectureList() {
        return lectureReadService.readAll();
    }
}
