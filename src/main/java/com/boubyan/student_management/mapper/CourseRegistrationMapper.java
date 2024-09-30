package com.boubyan.student_management.mapper;

import com.boubyan.student_management.entity.CourseRegistrationEntity;
import com.boubyan.student_management.model.request.CourseRegistrationRequest;
import com.boubyan.student_management.model.response.CourseRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseRegistrationMapper {

    CourseRegistrationMapper INSTANCE = Mappers.getMapper(CourseRegistrationMapper.class);

    @Mapping(source = "courseRegistrationRequest.courseId", target = "course.id")
    @Mapping(source = "courseRegistrationRequest.userId", target = "user.id")
    CourseRegistrationEntity mapToCourseRegistrationEntity(CourseRegistrationRequest courseRegistrationRequest);

    CourseRegistrationResponse mapToCourseRegistrationResponse(CourseRegistrationEntity courseRegistrationEntity);

}
