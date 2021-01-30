package com.example.catalog.service.impl;

import com.example.catalog.domain.Course;
import com.example.catalog.repository.CourseRepository;
import com.example.catalog.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Iterable<Course> getAll() {

        return courseRepository.findAll();

    }

    @Override
    public void add(Course course) {

        courseRepository.save(course);

    }

    @Override
    public void delete(Course course) {
        courseRepository.delete(course);
    }

    public Optional<Course> findById(Long id) {

        return courseRepository.findById(id);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }
}
