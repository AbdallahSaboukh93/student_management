package com.boubyan.student_management.mapper;

import com.boubyan.student_management.entity.ScheduleEntity;
import com.boubyan.student_management.model.request.ScheduleRequest;
import com.boubyan.student_management.model.response.ScheduleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    ScheduleEntity mapToScheduleEntity(ScheduleRequest scheduleRequest);

    ScheduleResponse mapToScheduleResponse(ScheduleEntity scheduleEntity);
}
