package com.tmdb.userms.service;

import com.tmdb.userms.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserDetailsByEmail(String email);
}
