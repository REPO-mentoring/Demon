package com.example.repoonlinevideo.domain.lecture.domain.repository;

import com.example.repoonlinevideo.domain.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
