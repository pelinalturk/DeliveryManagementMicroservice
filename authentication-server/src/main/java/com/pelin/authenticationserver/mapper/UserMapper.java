package com.pelin.authenticationserver.mapper;

import com.pelin.authenticationserver.dto.UserDto;
import com.pelin.authenticationserver.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDto convertToUserDto(User user);

}
