package com.boubyan.student_management.controller;

import com.boubyan.student_management.model.request.CourseRequest;
import com.boubyan.student_management.model.response.CourseResponse;
import com.boubyan.student_management.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Create Course", description = "createCourse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Create Course"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "403", description = "Forbidden ")
    })
    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest courseRequest) {
        return new ResponseEntity<>(courseService.createCourse(courseRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Get All Courses", description = "Get All Courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieve Courses"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "403", description = "Forbidden ")
    })
    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }


    @Operation(summary = "Get Course Schedule PDF", description = "Get Course Schedule PDF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieve Course Schedule PDF"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "403", description = "Forbidden ")
    })
    @GetMapping(value = "/schedule/pdf/{courseId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getCourseScheduleAsPdf(@PathVariable Long courseId) {
        return courseService.generateCourseSchedulePdf(courseId);
    }
}
