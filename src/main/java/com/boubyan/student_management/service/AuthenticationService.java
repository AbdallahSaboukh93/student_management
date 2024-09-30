package com.boubyan.student_management.service;

import com.boubyan.student_management.model.request.LoginRequest;
import com.boubyan.student_management.model.request.UserRequest;
import com.boubyan.student_management.model.response.LoginResponse;
import com.boubyan.student_management.model.response.UserResponse;

public interface AuthenticationService {
    UserResponse signup(UserRequest userRequest);

    LoginResponse authenticate(LoginRequest loginRequest);

}
