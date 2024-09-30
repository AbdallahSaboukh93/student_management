package com.boubyan.student_management.service;

import com.boubyan.student_management.model.request.CourseRequest;
import com.boubyan.student_management.model.response.CourseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();

    CourseResponse createCourse(CourseRequest courseRequest);

    ResponseEntity<byte[]> generateCourseSchedulePdf(Long courseId);
}
