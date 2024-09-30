package com.boubyan.student_management.model.response;

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
public class CourseRegistrationResponse  implements Serializable {

    private Long id;

    private UserResponse user;

    private CourseResponse course;

    private LocalDate registrationDate;

}
