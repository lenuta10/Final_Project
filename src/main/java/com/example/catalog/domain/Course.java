package com.example.catalog.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Number of credits is mandatory")
    private int numberOfCredits;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "course")
    private List<CourseRegistration> courseRegistrations;
}
