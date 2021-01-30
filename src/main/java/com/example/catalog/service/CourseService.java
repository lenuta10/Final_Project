package com.example.catalog.service;

import com.example.catalog.domain.Course;

import java.util.Optional;

public interface CourseService {

    Iterable<Course> getAll();

    void add(Course course);

    void delete(Course course);

    void save(Course course);

    Optional<Course> findById(Long id);
}
