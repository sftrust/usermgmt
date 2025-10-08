package com.sftrust.usermgmt.dto;

import com.sftrust.usermgmt.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private UserEntity user;
    private Integer responseCode;
}
