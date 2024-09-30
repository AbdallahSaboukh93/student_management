package com.boubyan.student_management.service.impl;

import com.boubyan.student_management.entity.CourseRegistrationEntity;
import com.boubyan.student_management.mapper.CourseRegistrationMapper;
import com.boubyan.student_management.model.request.CourseRegistrationRequest;
import com.boubyan.student_management.model.response.CourseRegistrationResponse;
import com.boubyan.student_management.repository.CourseRegistrationRepository;
import com.boubyan.student_management.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCourseRegistrationService implements CourseRegistrationService {

    @Autowired
    CourseRegistrationRepository courseRegistrationRepository;

    @Override
    public CourseRegistrationResponse registerToCourse(CourseRegistrationRequest registrationRequest) {
        CourseRegistrationEntity courseRegistrationEntity = courseRegistrationRepository.save(
                CourseRegistrationMapper.INSTANCE.mapToCourseRegistrationEntity(registrationRequest));
        return CourseRegistrationMapper.INSTANCE.mapToCourseRegistrationResponse(courseRegistrationEntity);
    }

    @Override
    public void cancelRegistration(Long registrationId) {
        // we can also add status for registration adn change it to canceled
        courseRegistrationRepository.deleteById(registrationId);
    }

}
