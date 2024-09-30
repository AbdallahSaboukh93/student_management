package com.boubyan.student_management.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistrationRequest implements Serializable {

    private long  userId;

    private long courseId;

    private LocalDate registrationDate;
}
