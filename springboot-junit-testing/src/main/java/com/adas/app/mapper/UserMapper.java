package com.adas.app.mapper;

import org.springframework.stereotype.Component;

import com.adas.app.dto.UserDto;
import com.adas.app.model.User;
import com.adas.app.request.UserRequest;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto map(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAlias(user.getAlias());
        userDto.setName(user.getName());
        return userDto;
    }

    public User map(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setAlias(userDto.getAlias());
        user.setName(userDto.getName());
        return user;
    }

    public User map(UserRequest userRequest) {
        User user = new User();
        user.setAlias(userRequest.getAlias());
        user.setName(userRequest.getName());
        return user;
    }

    public User map(int id, UserRequest userRequest) {
        User user = new User();
        user.setId(id);
        user.setAlias(userRequest.getAlias());
        user.setName(userRequest.getName());
        return user;
    }

    public List<UserDto> map(List<User> users) {
        return users
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
