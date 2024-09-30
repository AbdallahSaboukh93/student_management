package com.boubyan.student_management.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "schedule")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private String timeSlot; // Example: "10:00 AM - 12:00 PM"

    @Column(nullable = false)
    private String daysOfWeek; // Example: "Mon, Wed, Fri"

    @Column
    private String location;

    @OneToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;
}
