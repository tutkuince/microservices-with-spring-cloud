package com.incetutku.restapidevelopmentbasics.mapper;

import com.incetutku.restapidevelopmentbasics.dto.UserDTO;
import com.incetutku.restapidevelopmentbasics.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "emailAddress")
    UserDTO mapToUserDTO(User user);

    @Mapping(source = "emailAddress", target = "email")
    User mapToUser(UserDTO userDTO);
}
