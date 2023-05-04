package com.codecool.elproyectegrande1.mapper;

import com.codecool.elproyectegrande1.dto.user.UserDto;
import com.codecool.elproyectegrande1.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto mapEntityToDto(User user) {
        return new UserDto(
                user.getUsername(),
                user.getEmail(),
                user.getImageUrl(),
                user.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList()));
    }
}
