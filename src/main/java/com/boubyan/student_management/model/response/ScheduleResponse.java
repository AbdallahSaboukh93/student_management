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
public class ScheduleResponse implements Serializable {

    private long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String timeSlot; // Example: "10:00 AM - 12:00 PM"

    private String daysOfWeek; // Example: "Mon, Wed, Fri"

    private String location;
}
