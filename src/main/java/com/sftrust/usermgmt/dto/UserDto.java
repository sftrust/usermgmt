package com.sftrust.usermgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String phone;
    private String aadharNumber;
    private String panNumber;
    private String address;
    //    @Column(columnDefinition = "boolean default false") // define default value
    private Boolean isDonor;
    private Boolean isBeneficiary;
    private Boolean isVolunteer;
    private int vaultId;
    private String photoPath;
}
