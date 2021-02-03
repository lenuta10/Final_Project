package com.example.catalog.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(columnDefinition = "integer default 0")
    private int grade;
}
