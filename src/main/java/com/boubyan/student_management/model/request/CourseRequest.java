package com.boubyan.student_management.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest implements Serializable {

    private String courseCode;

    private String courseName;

    private String description;

    private ScheduleRequest schedule;

}