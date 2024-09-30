package com.boubyan.student_management.service;


import com.boubyan.student_management.model.request.CourseRegistrationRequest;
import com.boubyan.student_management.model.response.CourseRegistrationResponse;

public interface CourseRegistrationService {
    CourseRegistrationResponse registerToCourse(CourseRegistrationRequest registrationRequest);

    void cancelRegistration(Long registrationId);
}
