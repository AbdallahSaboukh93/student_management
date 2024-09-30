package com.boubyan.student_management.repository;

import com.boubyan.student_management.entity.CourseRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistrationRepository  extends JpaRepository<CourseRegistrationEntity, Long> {
}
