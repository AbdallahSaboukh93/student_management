package com.boubyan.student_management.mapper;

import com.boubyan.student_management.entity.UserEntity;
import com.boubyan.student_management.model.request.UserRequest;
import com.boubyan.student_management.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity mapToUserEntityUserEntity(UserRequest userRequest);

    UserResponse mapToUserResponse(UserEntity userEntity);
}
