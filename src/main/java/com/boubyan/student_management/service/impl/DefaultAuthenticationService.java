package com.boubyan.student_management.service.impl;

import com.boubyan.student_management.entity.UserEntity;
import com.boubyan.student_management.mapper.UserMapper;
import com.boubyan.student_management.model.request.LoginRequest;
import com.boubyan.student_management.model.request.UserRequest;
import com.boubyan.student_management.model.response.LoginResponse;
import com.boubyan.student_management.model.response.UserResponse;
import com.boubyan.student_management.repository.UserRepository;
import com.boubyan.student_management.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultAuthenticationService implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;


    @Override
    public UserResponse signup(UserRequest input) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(input.getUsername());
        if (!userEntity.isEmpty()) {
            throw new RuntimeException("This Email Used Before");
        }
        UserEntity user = new UserEntity();
        user.setUsername(input.getUsername());
        user.setName(input.getName());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        return UserMapper.INSTANCE.mapToUserResponse(userRepository.save(user));
    }

    @Override
    public LoginResponse authenticate(LoginRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );
        UserEntity userEntity = userRepository.findByUsername(input.getUsername())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(userEntity);

        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();
        return loginResponse;
    }


}
