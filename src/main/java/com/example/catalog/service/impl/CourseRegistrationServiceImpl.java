package com.example.catalog.service.impl;

import com.example.catalog.domain.CourseRegistration;
import com.example.catalog.repository.CourseRegistrationRepository;
import com.example.catalog.service.CourseRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

    private final CourseRegistrationRepository courseRegistrationRepository;

    public Optional<CourseRegistration> findById(Long id) {

        return courseRegistrationRepository.findById(id);
    }

    @Override
    public void save(CourseRegistration courseRegistration) {
        courseRegistrationRepository.save(courseRegistration);
    }

    @Override
    public List<CourseRegistration> getCourseRegistrations(String username){
        return courseRegistrationRepository.getCourseRegistrations(username);
    }

    @Override
    public List<CourseRegistration> getCourseRegistrationByUserRole(String role, Long id){
        return courseRegistrationRepository.getCourseRegistrationByUserRole(role, id);
    }

    @Override
    public List<CourseRegistration> getFinalList(String username)
    {
        List<CourseRegistration> returnList = new ArrayList<>();

        List<CourseRegistration> courseRegistrationList = getCourseRegistrations(username);

        for(CourseRegistration courseRegistration : courseRegistrationList)
        {
            returnList.addAll(getCourseRegistrationByUserRole("Student", courseRegistration.getCourse().getId()));
        }

        return returnList;
    }

    @Override
    public void deleteCourseRegistrationByUserAndCourse(Long user_id){
        courseRegistrationRepository.deleteCourseRegistrationByUserAndCourse(user_id);
    }
}
