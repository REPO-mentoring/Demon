package com.example.repoonlinevideo.domain.user.domain;

import com.example.repoonlinevideo.domain.lecture.domain.Lecture;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "tbl_user")
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Lecture> lecture = new ArrayList<>();
}
