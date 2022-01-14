package com.tmdb.userms.controller;

import com.tmdb.userms.dto.UserDto;
import com.tmdb.userms.request.CreateUserRequest;
import com.tmdb.userms.response.CreateUserResponse;
import com.tmdb.userms.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    Environment environment;

    @Autowired
    UserService userService;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Working on port " + environment.getProperty("local.server.port"));
    }

    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(createUserRequest, UserDto.class);
        UserDto user = this.userService.createUser(userDto);
        CreateUserResponse createUserResponse = modelMapper.map(user, CreateUserResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
    }

    @RequestMapping(value = "/login")
    public ResponseEntity<String> oauthLogin(Principal principal) {
        return ResponseEntity.ok("login-complete :"+ principal.getName());
    }

    @PostMapping(value = "/login-token")
    public ResponseEntity<String> token(Principal principal) {
        return ResponseEntity.ok("login-complete :"+ principal.getName());
    }
}
