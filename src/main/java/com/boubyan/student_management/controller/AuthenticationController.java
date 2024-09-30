package com.boubyan.student_management.controller;

import com.boubyan.student_management.model.request.LoginRequest;
import com.boubyan.student_management.model.request.UserRequest;
import com.boubyan.student_management.model.response.LoginResponse;
import com.boubyan.student_management.model.response.UserResponse;
import com.boubyan.student_management.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @Operation(summary = "Sign up ", description = "Sign up")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Sign Up"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "403", description = "Forbidden ")
    })
    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody UserRequest userRequest) {
        UserResponse registeredUser = authenticationService.signup(userRequest);
        return ResponseEntity.ok(registeredUser);
    }

    @Operation(summary = "Sign in ", description = "Sign in")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Sign In"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "403", description = "Forbidden ")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest LoginRequest) {
        LoginResponse loginResponse = authenticationService.authenticate(LoginRequest);
        return ResponseEntity.ok(loginResponse);
    }


}
