package com.sadcode.restapi.mapper;

import com.sadcode.restapi.dto.UserDto;
import com.sadcode.restapi.entity.User;

public class UserMapper {
    // Convert User Jpa Entity into UserDto
    public static UserDto mapToUserDto(User user) {
        /*UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return userDto;*/
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }

    // Convert UserDto Entity into User JPA entity
    public static User mapToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
    }
}
