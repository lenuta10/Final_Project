package com.example.catalog.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Data
@Entity
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(columnDefinition = "integer default 0")
    private int grade;
}
