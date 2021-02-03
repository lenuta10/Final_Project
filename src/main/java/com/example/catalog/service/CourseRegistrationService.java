package com.example.catalog.service;

import com.example.catalog.domain.CourseRegistration;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRegistrationService {

    void save(CourseRegistration course);

    Optional<CourseRegistration> findById(Long id);

    List<CourseRegistration> getCourseRegistrations(String username);

    List<CourseRegistration> getCourseRegistrationByUserRole(String role, Long id);

    List<CourseRegistration> getFinalList(String username);

    void deleteCourseRegistrationByUserAndCourse(Long user_id);


}
