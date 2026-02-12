package com.example.repoonlinevideo.domain.subcribe.domain.repository;

import com.example.repoonlinevideo.domain.lecture.domain.Lecture;
import com.example.repoonlinevideo.domain.subcribe.domain.Subcribe;
import com.example.repoonlinevideo.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcribeRepository extends JpaRepository<Subcribe, Long> {
    List<Subcribe> findByUser(User user);
    boolean existsByUserAndLecture(User user, Lecture lecture);

}
