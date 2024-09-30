package com.boubyan.student_management.mapper;

import com.boubyan.student_management.entity.CourseEntity;
import com.boubyan.student_management.model.request.CourseRequest;
import com.boubyan.student_management.model.response.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ScheduleMapper.class})
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseResponse mapToCourseResponse(CourseEntity courseEntity);

    List<CourseResponse> mapToCourseResponseList(List<CourseEntity> courseEntityList);

    CourseEntity mapToCourseEntity(CourseRequest courseRequest);
}
