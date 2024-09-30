package com.boubyan.student_management.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse  implements Serializable {

    private long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String courseCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String courseName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ScheduleResponse schedule;

}