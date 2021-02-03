package com.example.catalog.repository;


import com.example.catalog.domain.CourseRegistration;
import com.example.catalog.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRegistrationRepository extends CrudRepository<CourseRegistration, Long> {

    @Query("SELECT c FROM CourseRegistration c WHERE c.user.username = :username")
    List<CourseRegistration> getCourseRegistrations(@Param("username") String username);

    @Query("SELECT c FROM CourseRegistration c WHERE c.user.role = :role and c.course.id = :id order by c.course.name, c.user.firstName")
    List<CourseRegistration> getCourseRegistrationByUserRole(@Param("role") String role, @Param("id") Long id);

}
