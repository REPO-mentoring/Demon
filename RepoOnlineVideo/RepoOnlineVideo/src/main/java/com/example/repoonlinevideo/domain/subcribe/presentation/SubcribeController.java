package com.example.repoonlinevideo.domain.subcribe.presentation;

import com.example.repoonlinevideo.domain.subcribe.presentation.dto.request.SubcribeRequest;
import com.example.repoonlinevideo.domain.subcribe.service.SubcribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subcribe")
public class SubcribeController {
    private final SubcribeService subcribeService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void subcribe(@PathVariable Long id, @RequestBody SubcribeRequest subcribeRequest) {
        subcribeService.subcribeLecture(id , subcribeRequest);
    }
}
