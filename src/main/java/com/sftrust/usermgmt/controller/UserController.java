package com.sftrust.usermgmt.controller;

import com.sftrust.usermgmt.dto.UserDto;
import com.sftrust.usermgmt.dto.UserResponseDto;
import com.sftrust.usermgmt.entity.UserEntity;
import com.sftrust.usermgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDto userDto) {
        UserResponseDto userResponseWithCode = userService.createUser(userDto);
        return ResponseEntity.status(userResponseWithCode.getResponseCode())
                .body(userResponseWithCode.getUser());
    }
}
