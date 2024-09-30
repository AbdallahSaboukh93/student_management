package com.boubyan.student_management.controller;

import com.boubyan.student_management.model.request.CourseRegistrationRequest;
import com.boubyan.student_management.model.response.CourseRegistrationResponse;
import com.boubyan.student_management.service.CourseRegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registrations")
public class CourseRegistrationController {
    @Autowired
    CourseRegistrationService courseRegistrationService;


    @Operation(summary = "Create Course Registration", description = "Create Course Registration")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Create Course Registration"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "403", description = "Forbidden ")
    })
    @PostMapping("/register")
    public ResponseEntity<CourseRegistrationResponse> registerToCourse(@RequestBody CourseRegistrationRequest registrationRequest) {
        return new ResponseEntity<>(courseRegistrationService.registerToCourse(registrationRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Cancel Course Registration", description = "Cancel Course Registration")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Cancel Course Registration"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "403", description = "Forbidden ")
    })
    @DeleteMapping("/cancel/{registrationId}")
    public ResponseEntity<Void> cancelCourseRegistration(@PathVariable Long registrationId) {
        courseRegistrationService.cancelRegistration(registrationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
